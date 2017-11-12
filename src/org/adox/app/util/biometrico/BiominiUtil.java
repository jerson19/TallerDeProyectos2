package org.adox.app.util.biometrico;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Image;
import org.adox.app.view.aplicacion.ifAsistencias;
import org.adox.app.view.aplicacion.ifCapturas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;
import org.adox.app.entities.Asistencias;
import org.adox.app.entities.Personal;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.util.SIGEADMUtil;
import org.adox.app.util.SonidoUtil;
import org.adox.app.view.aplicacion.fInformacionAsistencia;
import static org.adox.app.view.aplicacion.ifAsistencias.lblControlAsistencia;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

public class BiominiUtil extends JFrame {

    private static final long serialVersionUID = 1L;
    private UFScannerClass libScanner;// = null;
    private UFMatcherClass libMatcher;// = null;    
    private UFScannerClass[] libScannerMulti;// = null;
    private UFMatcherClass[] libMatcherMulti;// = null;

    public Image fingerImg = null;
    private int nScannerNumber = 0;
    public int nC = 0;
    private int nInitFlag = 0;
    private int nCaptureFlag = 0;
    byte[] bTemplate = null;
    //private int nTemplateCnt = 0;
    private int nLogListCnt = 0;
    private Pointer hMatcher = null;
    //private PointerByReference refTemplateArray = null;  //  @jve:decl-index=0:
    Pointer[] pArray = null;
    //private String[] strTemplateArray = null;
    private int nSecurityLevel = 0;
    private int nFastMode = 0;
    //public final int MAX_TEMPLATE_SIZE = 384;
    private ifCapturas iF1 = null;
    private ifAsistencias iF2 = null;

    public BiominiUtil(ifCapturas oifCapturas) {
        iF1 = oifCapturas;
        inicializarPersistencia();
        InicializarBiomini();
    }

    public BiominiUtil(ifAsistencias oifAsistencias) {
        iF2 = oifAsistencias;
        inicializarPersistencia();
        InicializarBiomini();
    }
    /**
     * CONEXION A LA BASE DE DATOS
     */
    private Connection oConnection;
    static Logger oClass = Logger.getLogger("BiominiUtil");
    List<Personal> listaPersonalAsistencia;

    public EntityManager getEntityManager() {
        return frmPrincipal.oAplicacionDao.getObtenerConexionPU();
    }

    private void inicializarPersistencia() {
        try {
            oConnection = frmPrincipal.oReporte.getConexion();
            listaPersonalAsistencia = frmPrincipal.oNegocioDao.getListarPersonalAsistencia();
            System.out.println(" Se conecto al host");
        } catch (Exception e) {
            System.err.println(" No se pudo conectar al host de huellas");
            System.err.println(" Error ::: inicializarPersistencia() : " + e.getMessage());
        }
    }

    private void InicializarBiomini() {
        if (nInitFlag != 0) {
            MsgBox(" Info ::: InicializarBiomini() : Inicializacion Existente");
            ProgressUtil.stop();
            return;
        }
        Apagar_Identificar_Huella = 0;
        nCaptureFlag = 0;
        try {
            libScanner = (UFScannerClass) Native.loadLibrary("UFScanner", UFScannerClass.class);
            libMatcher = (UFMatcherClass) Native.loadLibrary("UFMatcher", UFMatcherClass.class);
        } catch (Exception ex) {
            setStatusMsg("loadLlibrary : UFScanner,UFMatcher fail!! " + ex);
            MsgBox("loadLlibrary : UFScanner,UFMatcher fail!! " + ex);
            ProgressUtil.stop();
            return;
        }
        int nRes = 0;

        nRes = libScanner.UFS_Init();
        if (nRes == 0) {
            nInitFlag = 1;
            //getJTextField_status().setText("UFS_Init() success,nInitFlag value set 1");
            //MsgBox("Scanner Init success!!");
            System.err.println(" Info ::: InicializarBiomini() : UFS_Init() : Scanner Init Satisfactorio");
            nRes = testCallScanProcCallback();
            if (nRes == 0) {
                setStatusMsg("==>UFS_SetScannerCallback pScanProc ...");
                IntByReference refNumber = new IntByReference();
                nRes = libScanner.UFS_GetScannerNumber(refNumber);
                if (nRes == 0) {
                    nScannerNumber = refNumber.getValue();
                    setStatusMsg("UFS_GetScannerNumber() scanner number :" + nScannerNumber);
                    PointerByReference refMatcher = new PointerByReference();
                    nRes = libMatcher.UFM_Create(refMatcher);
                    if (nRes == 0) {
                        System.out.println("after upadtelist");
                        initVariable(1);
                        System.out.println("after initVariable");

                        hMatcher = refMatcher.getValue();

                        IntByReference refValue = new IntByReference();
                        IntByReference refFastMode = new IntByReference();

                        //security level (1~7)
                        nRes = libMatcher.UFM_GetParameter(hMatcher, 302, refValue); //302 : security level :UFM_

                        if (nRes == 0) {
                            nSecurityLevel = refValue.getValue();//
                            setStatusMsg("get security level,302(security) value is " + refValue.getValue());
                        } else {
                            setStatusMsg("get security level fail! code: " + nRes);
                            MsgBox("get security level fail! code: " + nRes);
                        }
                        //fast mode

                        nRes = libMatcher.UFM_SetParameter(hMatcher, libMatcher.UFM_PARAM_FAST_MODE, refFastMode);
                        if (nRes == 0) {
                            nFastMode = refFastMode.getValue();
                            setStatusMsg("get fastmode,301(fastmode) value is " + refFastMode.getValue());
                        } else {
                            setStatusMsg("get fastmode value fail! code: " + nRes);
                            MsgBox("get fastmode value fail! code: " + nRes);
                        }
                        if (nFastMode == 1) {
                            //jCheckBox_fastmode.setSelected(true);
                        }

                        int nSelectedIdx = 0;//-ojComboBox_MatchType.getSelectedIndex();

                        if (hMatcher != null) {
                            switch (nSelectedIdx) {

                                case 0:
                                    nRes = libMatcher.UFM_SetTemplateType(hMatcher, libMatcher.UFM_TEMPLATE_TYPE_SUPREMA); //2001 Suprema type

                                    break;
                                case 1:
                                    nRes = libMatcher.UFM_SetTemplateType(hMatcher, libMatcher.UFM_TEMPLATE_TYPE_ISO19794_2); //2002 iso type

                                    break;
                                case 2:
                                    nRes = libMatcher.UFM_SetTemplateType(hMatcher, libMatcher.UFM_TEMPLATE_TYPE_ANSI378); //2003 ansi type

                                    break;
                            }
                        }

                    } else {
                        setStatusMsg("UFM_Create fail!! code :" + nRes);
                        ProgressUtil.stop();
                        return;
                    }

                } else {
                    MsgBox("GetScannerNumber fail!! code :" + nRes);
                    setStatusMsg("GetScannerNumber fail!! code :" + nRes);
                    return;
                }
            } else {
                setStatusMsg("UFS_SetScannerCallback() fail,code :" + nRes);
            }
        }

        if (nRes != 0) {
            System.out.println("Init() fail!!");
            setStatusMsg("Init fail!! return code:" + nRes);
            MsgBox("Scanner Init fail!!");
        }

    }

    public void MsgBox(String log) {
        JOptionPane.showMessageDialog(null, log);
    }

    public void setStatusMsg(String log) {
        log = nLogListCnt + ":" + log;
        System.out.println(log);
    }

    public void drawCurrentFingerImage() {
        /*test draw image*/
        IntByReference refResolution = new IntByReference();
        IntByReference refHeight = new IntByReference();
        IntByReference refWidth = new IntByReference();
        Pointer hScanner = null;

        hScanner = GetCurrentScannerHandle();

        libScanner.UFS_GetCaptureImageBufferInfo(hScanner, refWidth, refHeight, refResolution);

        byte[] pImageData = new byte[refWidth.getValue() * refHeight.getValue()];

        libScanner.UFS_GetCaptureImageBuffer(hScanner, pImageData);

        iF1.imgPanel.drawFingerImage(refWidth.getValue(), refHeight.getValue(), pImageData);
    }

    public int testCallScanProcCallback() {
        int nRes = 0;

        PointerByReference refParam = new PointerByReference();
        refParam.getPointer().setInt(0, 1);

        nRes = libScanner.UFS_SetScannerCallback(pScanProc, refParam);
        if (nRes == 0) {
            System.out.println("==>UFS_SetScannerCallback pScanProc ..." + pScanProc);

        }
        return nRes;
    }

    public int testCallStartCapturing() {
        int nRes = 0;

        Pointer hScanner = null;
        PointerByReference refParam = new PointerByReference();
        hScanner = GetCurrentScannerHandle();

        if (hScanner != null) {

            System.out.println("UFS_StartCapturing,get current scanner handle success! : " + hScanner);
            setStatusMsg("get Scanner handle success pointer:" + hScanner);

        } else {

            System.out.println("UFS_StartCapturing,GetScannerHandle fail!!");
            setStatusMsg("UFS_StartCapturing,get Scanner handle fail!!");

            return 0;
        }

        nRes = libScanner.UFS_StartCapturing(hScanner, pCaptureProc, refParam);

        if (nRes == 0) {
            setStatusMsg("UFS_StartCapturing success!!");
            System.out.println("UFS_StartCapturing success!!");
            nCaptureFlag = 1;

        } else {
            nCaptureFlag = 0;
            setStatusMsg("UFS_StartCapturing fail!! code:" + nRes);
        }

        return nRes;
    }

    public Pointer GetCurrentScannerHandle() {
        Pointer hScanner = null;
        int nRes = 0;
        int nNumber = 0;
        PointerByReference refScanner = new PointerByReference();
        IntByReference refScannerNumber = new IntByReference();
        nRes = libScanner.UFS_GetScannerNumber(refScannerNumber);
        if (nRes == 0) {
            nNumber = refScannerNumber.getValue();
            if (nNumber <= 0) {
                return null;
            }
        } else {
            return null;
        }
        int index = 0;//jList1_scanner_list.getSelectedIndex();
        if (index == -1) {
            index = 0;
        } else {
        }

        nRes = libScanner.UFS_GetScannerHandle(index, refScanner);
        hScanner = refScanner.getValue();
        System.out.println("hScanner " + hScanner);
        if (nRes == 0 && hScanner != null) {
            return hScanner;
        }
        // native@0x8f9b470
        return null;
    }

    public void initVariable(int nFlag) {
        if (nFlag == 1) { //UFS_Init\//
            nInitFlag = 1;
        } else {
            nInitFlag = 0;
        }
        nCaptureFlag = 0;
        nLogListCnt = 0;

        Pointer hScanner = null;
        hScanner = GetCurrentScannerHandle();
        IntByReference pValue = new IntByReference();
        //pValue.setValue(3000);
        pValue.setValue(0);
        int nRes = libScanner.UFS_SetParameter(hScanner, libScanner.UFS_PARAM_TIMEOUT, pValue);
        if (nRes == 0) {
            setStatusMsg("Change combox-timeout,201(timeout) value is " + pValue.getValue());
        } else {
            setStatusMsg("Change combox-timeout,change parameter value fail! code: " + nRes);
        }

        pValue.setValue(100);
        nRes = libScanner.UFS_SetParameter(hScanner, libScanner.UFS_PARAM_BRIGHTNESS, pValue);
        if (nRes == 0) {
            setStatusMsg("Change combox-brightness,202 value is " + pValue.getValue());
        } else {
            setStatusMsg("Change combox-brightness,change parameter value fail! code: " + nRes);
        }
        //NIVEL DE SENSIBILIDAD
        pValue.setValue(7);//Cambio de 7 a 6
        nRes = libScanner.UFS_SetParameter(hScanner, libScanner.UFS_PARAM_SENSITIVITY, pValue);
        if (nRes == 0) {
            setStatusMsg("Change combox-sensitivity,203 value is " + pValue.getValue());
        } else {
            setStatusMsg("Change combox-sensitivity,change parameter value fail! code: " + nRes);
        }

        nRes = libScanner.UFS_SetTemplateType(hScanner, libScanner.UFS_TEMPLATE_TYPE_SUPREMA); //2001 Suprema type
        if (nRes == 0) {
            setStatusMsg("Change combox-Scan TemplateType:2001");
        } else {
            setStatusMsg("Change combox-Scan TemplateType,change parameter value fail! code: " + nRes);
        }
    }

    public int CaptureSingle() {

        int nRes = 0;
        Pointer hScanner = null;
        System.out.println("call GetCurrentScannerHandle()");
        hScanner = GetCurrentScannerHandle();

        if (hScanner != null) {

            System.out.println("GetScannerHandle return hScanner pointer: " + hScanner);
            setStatusMsg("get Scanner handle success pointer:" + hScanner);

        } else {

            System.out.println("GetScannerHandle fail!!");
            setStatusMsg("get Scanner handle fail!!");

            return -1;
        }

        setStatusMsg("Start single image capturing");
        nRes = libScanner.UFS_CaptureSingleImage(hScanner);

        if (nRes == 0) {
            System.out.println("==>UFS_CaptureSingleImage return value is.." + nRes);
            nCaptureFlag = 1;
            drawCurrentFingerImage();

        } else {

            nCaptureFlag = 0;
            setStatusMsg("SingleImage fail!! code:" + nRes);
            byte[] refErr = new byte[512];
            nRes = libScanner.UFS_GetErrorString(nRes, refErr);
            if (nRes == 0) {
                System.out.println("==>UFS_GetErrorString err is " + Native.toString(refErr));
            }

            MsgBox("caputure single img fail!!");
        }

        return nRes;
    }
    UFScannerClass.UFS_SCANNER_PROC pScanProc = new UFScannerClass.UFS_SCANNER_PROC() {

        public int callback(String szScannerId, int bSensorOn, PointerByReference pParam) //interface ..must be implemeent
        {
            nC++;

            System.out.println(nC + "==========================================");  //
            System.out.println("==>ScanProc calle scannerID:" + szScannerId);  //  
            System.out.println("sensoron value is " + bSensorOn);
            System.out.println("void * pParam  value is " + pParam.getValue());
            System.out.println(nC + "==========================================");  //

//            UpdateScannerList();
            return 1;
        }
    };

    UFScannerClass.UFS_CAPTURE_PROC pCaptureProc = new UFScannerClass.UFS_CAPTURE_PROC() {

        public int callback(Pointer hScanner, int bFingerOn, Pointer pImage, int nWidth, int nHeight, int nResolution, PointerByReference pParam) {
            nC++;

            drawCurrentFingerImage();

            return 1;

        }
    };

    public void Enroll_Biomini() {
        if (nInitFlag == 0) {
            MsgBox("initiate!");
            return;
        }
        Pointer hScanner = null;
        hScanner = GetCurrentScannerHandle();
        if (hScanner != null) {
            int nRes = libScanner.UFS_ClearCaptureImageBuffer(hScanner);
            setStatusMsg("place a finger");
            nRes = libScanner.UFS_CaptureSingleImage(hScanner);
            setStatusMsg("capture single image");
            if (nRes == 0) {
                bTemplate = new byte[512];
                IntByReference refTemplateSize = new IntByReference();
                IntByReference refTemplateQuality = new IntByReference();
                try {
                    nRes = libScanner.UFS_Extract(hScanner, bTemplate, refTemplateSize, refTemplateQuality);
                    if (nRes == 0) {
                        setStatusMsg("save template file template size:" + refTemplateSize.getValue() + " quality:" + refTemplateQuality.getValue());
                        /*SETEAMOS LA CALIDAD MINIMA VALOR DEFECTO nSelectedValue=50*/
                        int nSelectedValue = 5;//Integer.parseInt((String) (jComboBox_enroll.getSelectedItem()));
                        if (refTemplateQuality.getValue() < nSelectedValue) {
                            MsgBox("Calidad de Huella < " + nSelectedValue);
                            ProgressUtil.stop();
                            return;
                        }
                        drawCurrentFingerImage();
                        nCaptureFlag = 1;
                        MsgBox("Captura de Huella Exitosa \nCalidad de Huella = " + refTemplateQuality.getValue());
                    } else {
                    }
                } catch (Exception ex) {
                    //MsgBox("exception err:"+ex.getMessage());
                }
            }
        } else {
            MsgBox("Escaner Biomini no encontrado ");
        }

    }

    public void Uninit_Suprema() {
        int nRes = libScanner.UFS_Uninit();
        if (nRes == 0) {
            setStatusMsg("UFS_Uninit sucess!!");
            nRes = libMatcher.UFM_Delete(hMatcher);
            nInitFlag = 0;
            setStatusMsg("UFS_Uninit sucess!!");
            try {
                oConnection.close();
            } catch (Exception e) {
                setStatusMsg("oConnection.close() Fallo");
            }
        } else {
            setStatusMsg("UFS_Uninit fail!!");
            try {
                oConnection.close();
            } catch (Exception e) {
                setStatusMsg("oConnection.close() Fallo");
            }
        }
    }
    /**
     * *********************************************************************
     */
    public static int Apagar_Identificar_Huella = 0;

    public void ApagarBiomini() {
        Apagar_Identificar_Huella = 1;
    }

    /**
     * Arreglo que contiene la longitud del dato de la huella
     */
    //private int fingerprintDataLength;
    public void GuardarHuella(String idPersonal) {
        LogsUtil.Show(oClass, "GuardarHuella " + idPersonal);
        try {
            Personal oPersonalSave = frmPrincipal.oNegocioDao.getObtenerPersonal(idPersonal.equals("") ? 0 : Integer.parseInt(idPersonal));
            oPersonalSave.setUsumod(Integer.parseInt(ConstantesApp.ID_USUARIO));
            oPersonalSave.setFecmodificacion(DateUtil.FechaHoraActualDateAlternativo());
            oPersonalSave.setHuella(bTemplate);
            String cUpdate = frmPrincipal.oNegocioDao.getActualizarPersonal(oPersonalSave);
            System.err.println("Ok al actualizar los datos de la huella." + cUpdate);
            MsgBox("Huella Actualizada Exitosamente...");

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.err.println("Error al guardar los datos de la huella." + ex.getMessage());
        }
    }

    public void IdentificarHuella() {
        System.err.println("::: IdentificarHuella ::: ");
        //Pointer hScanner = null;
        hScanner = GetCurrentScannerHandle();

        if (hScanner == null) {
            //setStatusMsg("getCurrentScannerHandle fail!! ");
            ProgressUtil.stop();
            return;
        }
        libScanner.UFS_ClearCaptureImageBuffer(hScanner);
        setStatusMsg("place a finger");
        int nRes = libScanner.UFS_CaptureSingleImage(hScanner);
        setStatusMsg("capture single image");
        if (nRes != 0) {
            setStatusMsg("caputure single image fail!! " + nRes);
            ProgressUtil.stop();
            return;
        }
        setStatusMsg("Iniciando bTemplate");
        bTemplate = new byte[1024];
        try {
            //Si se encuentra el nombre en la base de datos
            for (Personal personal : listaPersonalAsistencia) {
                //Lee la plantilla de la base de datos

                IntByReference refTemplateSize = new IntByReference();
                IntByReference refTemplateQuality = new IntByReference();
                nRes = libScanner.UFS_Extract(hScanner, bTemplate, refTemplateSize, refTemplateQuality);
                if (nRes == 0) {
                    libMatcher.UFM_IdentifyInit(hMatcher, bTemplate, refTemplateSize.getValue());
                    IntByReference refIdentifyRes = new IntByReference();

                    nRes = libMatcher.UFM_IdentifyNext(hMatcher, personal.getHuella(), bTemplate.length, refIdentifyRes);
                    if (nRes == 0) {
                        if (refIdentifyRes.getValue() == 1) {
                            setStatusMsg("La Huella pertenece a : " + personal.getNombre());
                            MsgBox("La Huella pertenece a : " + personal.getNombre());
                            ProgressUtil.stop();
                            return;
                        } else {
                            //Si no encuentra alguna huella que coincida lo indica con un mensaje
                            JOptionPane.showMessageDialog(iF1, "Huella no Registrada");
                            ProgressUtil.stop();
                            return;
                        }
                    }
                } else {
                    setStatusMsg("Captura de Huella no Valida");
                    MsgBox("Captura de Huella no Valida");
                    ProgressUtil.stop();
                    return;
                }
            }
        } catch (Exception e) {
            ProgressUtil.stop();
            setStatusMsg("Exepcion " + e.getMessage());
        }
    }

    /**
     * *************************************************************************************************
     */
    Pointer hScanner = null;
    Thread p;
    //String idPersonal = "";

    public void IdentificarAsistencia() {
        while (Apagar_Identificar_Huella == 0) {
            IdentificarGuardarAsistencia();
        }
    }

    public void IdentificarGuardarAsistencia() {
        hScanner = null;
        hScanner = GetCurrentScannerHandle();
        if (hScanner == null) {
            //setStatusMsg("getCurrentScannerHandle fail!! ");
            return;
        }
        IdentificarGuardarAsistenciaImpl();
    }

    Thread[] pHuella;
    int exitoProcesamiento = 0;
    int PARALELISMO = 4;
    SonidoUtil sonido = new SonidoUtil(oClass);

    public void IdentificarGuardarAsistenciaImpl() {
        exitoProcesamiento = 0;
        libScanner.UFS_ClearCaptureImageBuffer(hScanner);
        setStatusMsg("place a finger");
        int nRes = libScanner.UFS_CaptureSingleImage(hScanner);
        setStatusMsg("capture single image");
        if (nRes != 0) {
            setStatusMsg("caputure single image fail!! " + nRes);
            //ProgressUtil.stop();
            return;
        }
        arrayLibreriasSDK(PARALELISMO + 1);
        setStatusMsg("Iniciando bTemplate");
        bTemplate = new byte[1024];

        int tamanioLista = listaPersonalAsistencia.size();
        int nroProcesos = tamanioLista / PARALELISMO;
        int nroProcesosSobra = tamanioLista % PARALELISMO;
        System.out.println("Tamaño lista : " + tamanioLista + " Nro Procesos : " + nroProcesos + " Nro Procesos resta : " + nroProcesosSobra);
        int tempi = 0, tempf = 0;
        pHuella = new Thread[PARALELISMO];
        for (int x = 0; x < PARALELISMO; x++) {
            tempf = tempi + nroProcesos;
            if (x == (PARALELISMO - 1)) {
                tempf = tempf + nroProcesosSobra;
            }
            if (nroProcesos == 0) {
                tempf = nroProcesosSobra;
                x = 10;
            }
            List<Personal> listaTemp = listaPersonalAsistencia.subList(tempi, tempf);
            tempi = tempf;
            procesaHuellaThread(x, listaTemp, nRes);
        }
        System.out.println(":::::::: ANTES DE  WHILE ::::::::::::");
        do {
            if (!pHuella[0].isAlive()) {
                if (!pHuella[1].isAlive()) {
                    if (!pHuella[2].isAlive()) {
                        if (!pHuella[3].isAlive()) {
                            exitoProcesamiento = 2;
                        }
                    }
                }
            }
        } while (exitoProcesamiento < 1);
        try {

            if (exitoProcesamiento == 2) {
                sonido.daleplay(ConstantesApp.SONIDO_ASISTENCIA_ERROR);
                setStatusMsg("Captura de Huella no Valida");
                fInformacionAsistencia ofInformacionAsistencia = new fInformacionAsistencia("personal", "-------", "HUELLA NO ENCONTRADA, VUELVA A INTENTARLO", DateUtil.Hora_HHMMSS());
                ofInformacionAsistencia.setVisible(true);
                //ProgressUtil.stop();
            }
            System.err.println("::::::::::::::::FIN DEL PROCESO DE RECONOCIMIENTO DE HUELLA::::::::");
        } catch (Exception e) {
            LogsUtil.Show(oClass, "Ocurrio Problemas al identificar la huella  " + e.getMessage());
        }
    }

    private void procesaHuellaThread(final int i, final List<Personal> listPersonas, final int nRes) {
        pHuella[i] = new Thread() {

            @Override
            public void run() {
                try {
                    procesaHuella(i, listPersonas, nRes);
                    pHuella[i].interrupt();
                    //System.out.println("ESTADO ACTUAL THREAD " + i + " : " + pHuella[i].getState() + " - " + pHuella[i].isInterrupted());
                    pHuella[i].stop();
                } catch (Exception e) {
                    LogsUtil.Show(oClass, "FALLO INICIANDO SYNCRONIZADOR " + e.getMessage());
                }
            }
        };
        pHuella[i].start();
    }

    public synchronized void procesaHuella(int i, List<Personal> listPersonas, int nRes) {
        //Si se encuentra el nombre en la base de datos
        try {
            int exitoProcesamientoTemp = 0;
            String idPersonal = "";
            Personal oPersonal = null;
            //setStatusMsg("ResultSet rsIdentificar Ejecutado");
            for (Personal objPersonal : listPersonas) {
                //if (exitoProcesamiento == 0) {

                //Lee la plantilla de la base de datos
                IntByReference refTemplateSize = new IntByReference();
                IntByReference refTemplateQuality = new IntByReference();
                nRes = libScannerMulti[i].UFS_Extract(hScanner, bTemplate, refTemplateSize, refTemplateQuality);
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidió.
                if (nRes == 0) {
                    libMatcherMulti[i].UFM_IdentifyInit(hMatcher, bTemplate, refTemplateSize.getValue());
                    IntByReference refIdentifyRes = new IntByReference();
                    //int i = 0;
                    nRes = libMatcherMulti[i].UFM_IdentifyNext(hMatcher, objPersonal.getHuella(), bTemplate.length, refIdentifyRes);
                    if (nRes == 0) {
                        if (refIdentifyRes.getValue() == 1) {
                            oPersonal = objPersonal;
                            exitoProcesamiento = 1;
                            exitoProcesamientoTemp = 1;
                            break;
                        }
                    }
                }
            }

            if (exitoProcesamientoTemp == 1) {

                System.out.println(":::: REGISTRANDO LA ASISTENCIA DE LA HUELLA ENCONTRADA ::::::::::::::::");
                idPersonal = oPersonal.getIdpersonal().toString();
                String nomPersonal = oPersonal.getNombre() + " " + oPersonal.getApepat() + " " + oPersonal.getApemat();
                String nroDocumento = oPersonal.getNrodocumento();
                String horario = oPersonal.getHorario();

                PreparedStatement consutaHorarioStmt;
                consutaHorarioStmt = oConnection.prepareStatement("SELECT descripcion FROM subtabla WHERE idtabla=6 AND codigo=?");
                consutaHorarioStmt.setString(1, horario);
                ResultSet rsConsultaHorario = consutaHorarioStmt.executeQuery();
                if (rsConsultaHorario.next()) {
                    horario = rsConsultaHorario.getString(1);
                }
                LogsUtil.Show(oClass, "Huella de personal encontrada " + nomPersonal + " Horario : " + horario);
                //LA HUELLA FUE ENCONTRADA 
                try {
                    String hingres = iF2.lblHora.getText().trim();
                    String fechaProceso = null;
                    String mes = null;
                    String anio = null;
                    String horaProceso = SIGEADMUtil.HoraInicioAsistencia(oConnection, hingres);
                    if (ConstantesApp.HORA_CERO.equals(horaProceso)) {
                        fechaProceso = DateUtil.fechaAplicacionMasDias(-1);
                        anio = String.valueOf(fechaProceso.split("-")[0]);
                        mes = DateUtil.nombremes(Integer.valueOf(fechaProceso.split("-")[1]));
                    } else {
                        fechaProceso = DateUtil.FechaActualString();
                        mes = DateUtil.Mes();
                        anio = DateUtil.Anio();
                    }
                    //System.out.println("NOMBRE DE MES Y AÑO " + mes + " - " + anio);
                    PreparedStatement identificarAsistenciaStmt;
                    identificarAsistenciaStmt = oConnection.prepareStatement("SELECT idasistencias,hingreso FROM asistencias where nrodocumento=? and fecha=?");
                    identificarAsistenciaStmt.setString(1, nroDocumento);
                    identificarAsistenciaStmt.setString(2, fechaProceso);
                    ResultSet rsIdentificarAsistencia = identificarAsistenciaStmt.executeQuery();
                    Integer id = 0;
                    if (rsIdentificarAsistencia.next()) {
                        id = rsIdentificarAsistencia.getInt(1);
                    }
                    String TipoMovimiento = null;
                    Asistencias oAsistencias = new Asistencias();
                    if (id == 0) {
                        TipoMovimiento = ConstantesApp.ASISTENCIAS_ENTRADA;
                        /* Logica para definir si ya tiene las 3 tardanzas en el mes */
                        int nroTardanzas = 0;
                        int nroTardanzasTemp = 0;
                        PreparedStatement consutaTardanzasStmt;
                        consutaTardanzasStmt = oConnection.prepareStatement("SELECT tardanzas FROM rptasistencias WHERE mes='" + mes + "' AND ano='" + anio + "' AND idPersonal=?");
                        consutaTardanzasStmt.setString(1, idPersonal);
                        ResultSet rsConsultaTardanza = consutaTardanzasStmt.executeQuery();
                        if (rsConsultaTardanza.next()) {
                            nroTardanzas = rsConsultaTardanza.getInt(1);
                            nroTardanzasTemp = nroTardanzas;
                        }
                        /* Logica para calcular la tardanza */
                        int min = 0;
                        String Asist = "";
                        String[] puntualidad = null;
                        try {
                            puntualidad = SIGEADMUtil.CalcularPuntualidad(oConnection, horario, hingres, nroTardanzasTemp);
                            min = Integer.parseInt(puntualidad[1]);
                            Asist = puntualidad[3];
                        } catch (Exception e) {
                            min = 0;
                        }

                        oAsistencias.setIdpersonal(Integer.parseInt(idPersonal));
                        oAsistencias.setNrodocumento(nroDocumento);
                        oAsistencias.setPersonal(nomPersonal);
                        oAsistencias.setHingreso(hingres);

                        oAsistencias.setTardanza(min);
                        oAsistencias.setFalta(Asist);
                        oAsistencias.setFecha(fechaProceso);
                        String oAsistencia = frmPrincipal.oNegocioDao.getRegistrarAsistencias(oAsistencias);
                        RegistroReporteAsistenciaMensual(idPersonal, mes, anio, nroTardanzas, puntualidad);

                        //ifAsistencias.lblControlAsistencia.setText("<html> <center><MARQUEE> <font color = 'white'>" + DateUtil.fechaAplicacionPanel() + "</font></MARQUEE></center> </html>");
                        try {
                            lblControlAsistencia.setText("" + DateUtil.fechaAplicacion2() + "");
                        } catch (Exception e) {
                            System.out.println("ERROR AL CAMBIAR DE TEXTO " + e.getMessage());
                        }
                    } else {
                        TipoMovimiento = ConstantesApp.ASISTENCIAS_SALIDA;
                        EntityManager em = getEntityManager();
                        em.getTransaction().begin();
                        oAsistencias
                                = em.find(Asistencias.class, id);
                        oAsistencias.setHsalida(iF2.lblHora.getText());
                        em.merge(oAsistencias);

                        em.getTransaction().commit();
                        em.close();
                    }
                    try {
                        lblControlAsistencia.setText("" + DateUtil.fechaAplicacion2() + "");
                    } catch (Exception e) {
                        System.out.println("ERROR AL CAMBIAR DE TEXTO " + e.getMessage());
                    }
                    sonido.daleplay(ConstantesApp.SONIDO_ASISTENCIA_REGISTRO);
                    fInformacionAsistencia ofInformacionAsistencia = new fInformacionAsistencia(nroDocumento, nomPersonal, TipoMovimiento, iF2.lblHora.getText());
                    ofInformacionAsistencia.setVisible(true);                    //ProgressUtil.stop();

                } catch (Exception e) {
                    exitoProcesamiento = 0;
                    sonido.daleplay(ConstantesApp.SONIDO_ASISTENCIA_ERROR);
                    //JOptionPane.showMessageDialog(null, "No existe registro de asistencia de hoy dia");
                    fInformacionAsistencia ofInformacionAsistencia = new fInformacionAsistencia(nroDocumento, "-------", "ATENCION, VUELVA A INTENTARLO : " + e.getMessage(), DateUtil.Hora_HHMMSS());
                    ofInformacionAsistencia.setVisible(true);
                    //ProgressUtil.stop();
                }

            }
        } catch (Exception e) {
            LogsUtil.Show(oClass, "Ocurrio Problemas al identificar la huella  1 " + e.getMessage());
        }
    }

    public void arrayLibreriasSDK(int array) {
        libScannerMulti = new UFScannerClass[array];
        libMatcherMulti = new UFMatcherClass[array];

        for (int x = 0; x < array; x++) {
            libScannerMulti[x] = libScanner;
            libMatcherMulti[x] = libMatcher;
        }
    }

    private void RegistroReporteAsistenciaMensual(String idPersonal, String mes, String anio, int tardanzas, String[] puntualidad) {
        System.out.println(":::::::::::::: RegistroReporteAsistenciaMensual ;:::::::::::::::");
        EntityManager em = getEntityManager();
        Query qObtenerRegistroRpte = em.createNativeQuery("SELECT COUNT(*) FROM rptasistencias WHERE idPersonal = '" + idPersonal + "' AND Mes = '" + mes + "' AND Ano = '" + anio + "'");
        Object contador = qObtenerRegistroRpte.getSingleResult();
        System.out.println("contador :  " + contador.toString());
        em.close();
        if (contador.toString().trim().equals("1")) {
            System.out.println(":::: CUANDO YA EXISTE EL REPORTE MENSUAL Y SE ACTUALIZA");
            actAsistencia(idPersonal, mes, anio, tardanzas, puntualidad);
        } else {
            System.out.println(":::: INSRTA POR PRIMERA VEZ AL REPORTE MENSUAL");
            /*Aca se registra la primera vez para el reporte general*/
            regAsistencia(idPersonal, mes, anio);
            actAsistencia(idPersonal, mes, anio, tardanzas, puntualidad);
        }

    }

    private void regAsistencia(String idPersonal, String mes, String anio) {
        EntityManager em = getEntityManager();
        String Query = "call spObtenerDatosPersonal(" + idPersonal + ")";
        System.out.println("Query spObtenerDatosPersonal :  " + Query);
        Query qObtenerDatosPersonal = em.createNativeQuery("call spObtenerDatosPersonal(" + idPersonal + ")");
        Object Datos = qObtenerDatosPersonal.getSingleResult();
        System.out.println("Datos :  " + Datos.toString());
        Object[] fila = Datos.toString().trim().split("-");
        Query = "INSERT INTO rptasistencias (Mes,Ano,idPersonal,Paterno,Materno,Nombres,Cargo,Asistencias,Inasistencias,Feriados,tardanzas) "
                + "VALUES ('" + mes + "','" + anio + "'," + idPersonal + ",'" + fila[0].toString() + "', '" + fila[1].toString() + "','" + fila[2].toString() + "','" + fila[3].toString() + "','0','0','0','0')";
        System.out.println("Query qRegistroRpte:  " + Query);
        em.getTransaction().begin();
        Query qRegistroRpte = em.createNativeQuery(Query);
        int rpta = qRegistroRpte.executeUpdate();
        System.out.println("rpta " + rpta);
//        if (rpta == 1) {
//            JOptionPane.showMessageDialog(this, "Registro de Asistencia Exitosa");
//        } else {
//            JOptionPane.showMessageDialog(this, "Registro de Asistencia Fallo");
//        }
        em.getTransaction().commit();
    }

    private void actAsistencia(String idPersonal, String mes, String anio, int tardanzas, String[] Puntualidad) {
        EntityManager em = getEntityManager();
        String dia;
        try {
            dia = DateUtil.FechaActualString();
        } catch (Exception e) {
            dia = DateUtil.fechaAplicacion();
        }
        String[] diaActual = dia.split("-");
        System.out.println("diaActual :  " + diaActual[2]);
        //CALCULAR SI ES TARDANZA O PUNTUALIDAD
        //String[] Puntualidad = SIGEADMUtil.CalcularPuntualidad(oConnection, idPersonal, hIngreso, tardanzas);
        tardanzas = Integer.valueOf(Puntualidad[2]);

        String Query = "UPDATE rptasistencias SET d" + Integer.parseInt(diaActual[2]) + "='" + Puntualidad[0] + "', tardanzas='" + tardanzas + "'"
                + " WHERE idPersonal = '" + idPersonal + "' AND Mes = '" + mes + "' AND Ano = '" + anio + "'";
        System.out.println("Query :  " + Query);
        em.getTransaction().begin();
        Query qObtenerActualizaRptAsistencia = em.createNativeQuery(Query);
        int rpta = qObtenerActualizaRptAsistencia.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("rpta " + rpta);
    }

}
