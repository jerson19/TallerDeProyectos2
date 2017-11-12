package org.adox.app.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.adox.app.common.ConstantesApp;
import org.apache.log4j.Logger;

public class SIGEADMUtil {
//
//    public UescaUtil() {
//        emf = _CFGConexionManager.getEntityManagerFactory();
//    }
//    private EntityManagerFactory emf;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }

    static Logger oClass = Logger.getLogger("SIGEADMUtil");

    public static String CalcularDescuento10Min(String Sueldo) {
        BigDecimal descuento = new BigDecimal("0.00");
        BigDecimal descuentoHora = new BigDecimal("0.00");
        BigDecimal descuentoTotal = new BigDecimal("0.00");
        //descuento = MathUtil.DividirBigDecimal(Sueldo, "150.00");
        descuento = MathUtil.DividirBigDecimal(Sueldo, ConstantesApp.HORAS_TRABAJO);
        LogsUtil.Show(oClass, " descuentoHora  S/. " + descuento);
        descuentoHora = MathUtil.DividirBigDecimal(descuento.toString(), "60.00");
        LogsUtil.Show(oClass, " descuentoMinuto S/.  " + descuentoHora);
        descuentoTotal = MathUtil.MultiplicarBigDecimal(descuentoHora.toString(), "10.00");
        LogsUtil.Show(oClass, " descuento_10_Min S/. " + descuentoTotal);
        //descuento=descuento/60*10;
        return descuentoTotal.doubleValue() + "";
    }

    public static String HoraInicioAsistencia(Connection oConnection, String hIngreso) {
        LogsUtil.LogsApp(oClass, "horaInicioAsistencia() ", ConstantesApp.ERROR_INFO);
        String tiempoTranscurrido = ConstantesApp.HORA_CERO;
        try {
            PreparedStatement ObtenerTiempoTranscurrido;
            String query = "SELECT SEC_TO_TIME(TIME_TO_SEC('" + hIngreso + "')-TIME_TO_SEC('05:00:00'))";
            LogsUtil.Show(oClass, "query " + query);
            ObtenerTiempoTranscurrido = oConnection.prepareStatement(query);
            ResultSet Tiempo = ObtenerTiempoTranscurrido.executeQuery();
            if (Tiempo.next()) {
                tiempoTranscurrido = Tiempo.getString(1);
            }
            /*ObtenerTiempoTranscurrido.close();
             Tiempo.close();
             oConnection.close();*/
        } catch (Exception ex) {
            tiempoTranscurrido = ConstantesApp.HORA_CERO;
            LogsUtil.LogsApp(oClass, "FALLO OBTENCION DE MINUTOS TRANSCURRIDOS " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        }
        LogsUtil.Show(oClass, "HORA INGRESO        " + hIngreso);
        LogsUtil.Show(oClass, "TIEMPO TRANSCURRIDO " + tiempoTranscurrido);

        return tiempoTranscurrido;
    }

    public static String[] CalcularPuntualidad(Connection ojdbc, String horario, String hIngreso, int nroTardanzas) {
        LogsUtil.LogsApp(oClass, "CalcularPuntualidad() ", ConstantesApp.ERROR_INFO);
        String minutos = ConstantesApp.HORA_CERO;
        try {
            Connection oConnection = ojdbc;
            PreparedStatement ObtenerTiempoTranscurrido;
            String query = "SELECT SEC_TO_TIME(TIME_TO_SEC('" + hIngreso + "')-TIME_TO_SEC('" + horarioFormatoHora(horario) + "'))";
            //LogsUtil.Show(oClass, "query " + query);
            ObtenerTiempoTranscurrido = oConnection.prepareStatement(query);
            ResultSet Tiempo = ObtenerTiempoTranscurrido.executeQuery();
            if (Tiempo.next()) {
                minutos = Tiempo.getString(1);
            }
        } catch (SQLException ex) {
            minutos = ConstantesApp.HORA_CERO;
            LogsUtil.LogsApp(oClass, "FALLO OBTENCION DE MINUTOS TRANSCURRIDOS " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        }
        /*LogsUtil.Show(oClass, "HORA INGRESO        " + hIngreso);
         LogsUtil.Show(oClass, "TIEMPO TRANSCURRIDO " + minutos);*/
        return Puntualidad(minutos, nroTardanzas);
    }

    public static String[] Puntualidad(String minutos, int nroTardanzas) {
        String[] Puntualidad = new String[4];
        int minTardanza = 0;
        String asistencia = "0";
        String puntualidad = "";

        if (ConstantesApp.HORA_CERO.equals(minutos)) {
            asistencia = ConstantesApp.ASISTENCIA_PUNTUAL;
            puntualidad = "";
            minTardanza = 0;
        } else {
            asistencia = ConstantesApp.ASISTENCIA_TARDE;
            puntualidad = ConstantesApp.PUNTUALIDAD_TARDE;
            String[] Tiempo = minutos.split(":");
            int hora = Integer.parseInt(Tiempo[0]);
            int minuto = Integer.parseInt(Tiempo[1]);
            int segundo = Integer.parseInt(Tiempo[2]);
            /*LogsUtil.Show(oClass, "DATOS HORA " + hora);
             LogsUtil.Show(oClass, "DATOS MINUTO " + minuto);
             LogsUtil.Show(oClass, "DATOS SEGUNDO " + segundo);   */
            minTardanza = hora * 60 + minuto;
            if (minTardanza <= 10) {
                asistencia = ConstantesApp.ASISTENCIA_PUNTUAL;
                puntualidad = "";
                minTardanza = 0;
            } else if (nroTardanzas < 3) {
                if (minTardanza <= 30) {
                    asistencia = ConstantesApp.ASISTENCIA_PUNTUAL;
                    puntualidad = "";
                    nroTardanzas++;
                    minTardanza = 0;
                } else {
                    asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    puntualidad = ConstantesApp.PUNTUALIDAD_TARDE;
                }
                //nroTardanzas=0;
            }
        }

        /*LogsUtil.Show(oClass, "MINUTOS DE TARDANZA " + minTardanza);
         LogsUtil.Show(oClass, "CALCULO ASISTENCIA " + asistencia);*/
        Puntualidad[0] = asistencia;
        Puntualidad[1] = minTardanza + "";
        Puntualidad[2] = nroTardanzas + "";
        Puntualidad[3] = puntualidad;
        return Puntualidad;
    }

    public static String horarioFormatoHora(String horario) {
        String[] Horarios = horario.split(" ");
        String horaEntrada = Horarios[1].split("-")[0] + ":00";
        //String horaSalida=Horarios[1].split("-")[1]+":00";
        return horaEntrada;
    }
}
