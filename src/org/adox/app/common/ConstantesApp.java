/**
 * @serial V1
 * @author Adolfo
 */
package org.adox.app.common;

public class ConstantesApp {
    
    public static final java.util.ResourceBundle constantes = java.util.ResourceBundle.getBundle("constantes");
    
    public static String TIPO_APP = constantes.getString("TIPO_APP");
    /*CARGA CONSTANTES DEL PROPERTIES*/
    public static String LOOK_AND_FEEL = constantes.getString("LOOK_AND_FEEL");
    public static String HORA_ENTRADA_ASISTENCIA = constantes.getString("HORA_ENTRADA_ASISTENCIA");
    public static String HORA_ENTRADA = constantes.getString("HORA_ENTRADA");
    public static String HORA_SALIDA_REFRIGERIO = constantes.getString("HORA_SALIDA_REFRIGERIO");
    public static String HORA_ENTRADA_REFRIGERIO = constantes.getString("HORA_ENTRADA_REFRIGERIO");
    public static String HORA_SALIDA = constantes.getString("HORA_SALIDA");
    /* Codigos de productividad y descuento laboral */
    public static String STATE_PRODUCTIVIDAD = constantes.getString("STATE_PRODUCTIVIDAD");
    public static String HORAS_TRABAJO = constantes.getString("HORAS_TRABAJO");
    /* Codigos de las tablas de codigo descripcion */
    public static Integer SEXO_MASCULINO = 1;
    public static Integer SEXO_FEMENINO = 2;
    public static String TABLA_TIPO_DOCUMENTO = "3";
    public static String TABLA_TIPO_CARGOS = "4";
    public static String TABLA_TIPO_PROFESION = "5";
    public static String TABLA_TIPO_HORARIO = "6";
    public static String TABLA_ESTADO_PERSONAL = "7";
    public static String TABLA_CATEGORIA = "8";

    /* CODIGOS DE ASISTENCIA */
    public static String ASISTENCIAS_ENTRADA = "ENTRADA";
    public static String ASISTENCIAS_SALIDA = "SALIDA";
    //public static char ASISTENCIAS_SELEC = '1';
    public static String ASISTENCIA_PUNTUAL = "1";
    public static String ASISTENCIA_TARDE = "2";
    public static String ASISTENCIA_FALTA = "0";
    public static String HORA_CERO = "00:00:00";
    public static String PUNTUALIDAD_TARDE = "TARDE";
    /* CODIGOS DE PRODUCTIVIDAD */
    public static Integer ESTADO_PRODUCTIVIDAD_REGISTRADO = 1; //ESTADO INICIAL
    public static Integer ESTADO_PRODUCTIVIDAD_APROBADO = 2;   //ESTADO FINAL
    public static Integer ESTADO_PRODUCTIVIDAD_RECHAZADO = 0;
    public static String REPORTE_TYPE_PDF = "PDF";
    public static String REPORTE_TYPE_HTML = "HTML";
    // ::::::::::::::::::: APLICACION :::::::::::::::::::::::::::::::::
    public static int APP = 0;
    public static String ID_USUARIO = "0";
    public static String ID_PERSONAL = "0";
    public static String USUARIO = "";
    public static String ID_ROL = "0";
    public static String ID_EMPRESA = "0";
    public static String EMPRESA = "";
    public static String EntityManagerFactory = "appPU";
    public static String EMPTY = "";
    /* Los numeros */
    public static String CER0 = "0";
    public static int UNO = 1;
    public static int DOS = 2;
    public static int TRES = 3;
    /* Constantes para los tipos de errores  */
    public static char ERROR_INFO = 'I';
    public static char ERROR_DEBUG = 'D';
    public static char ERROR_WARN = 'W';
    public static char ERROR_ERROR = 'E';
    public static char ERROR_FATAL = 'F';

    /* Constantes para los mensajes de logs*/
    public static String MSG_INFO_INICIO_APP = "========== INICIANDO LA APLICACION ========= ";
    public static String MSG_INFO_LOKK_FEEL_EXITOSO = "Se cargo el el look and field exitosamente";
    public static String MSG_INFO_LOKK_FEEL_FALLO = "No se pudo cargar el look and field";
    public static String MSG_INFO_SONIDO = "Reproduciendo sonido de inicio del sistema";
    public static String MSG_INFO_LOGIN = "Se instancia el formulario de logeo";
    public static String MSG_INFO_FRMLOGIN = "Se inizializa los componentes y el perfil";

    /* Constantes para look and feel  */
    public static String LOOK_FEEL_SUBTANCE = "org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel";
    public static String LOOK_FEEL_SUBTANCE1 = "org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel";
    //public static NimRODLookAndFeel LOOK_FEEL_SUBTANCE2 = new com.nilo.plaf.nimrod.NimRODLookAndFeel();

    /* Todas las clases de aplicacion */
    public static String CLASE_MAIN = "org.adox.app.Main";
    public static String CLASE_CONEXION = "org.adox.app.config.jdbc._CFGConexion";
    public static String CLASE_FRMLOGIN = "org.adox.app.view.frmLogin";
    public static String CLASE_SERVICIO_SPRING = "org.adox.app.common.ServicioSpring";

    /* Todas los sonidos de la aplicacion */
    public static String SONIDO_INICIO = "bienvenido";
    public static String SONIDO_SALIDA = "salir";
    public static String SONIDO_ASISTENCIA_REGISTRO = "asistenciaOK";
    public static String SONIDO_ASISTENCIA_ERROR = "asistenciaERROR";

    /* Mensaje de confirmacion */
    public static String MENSAJE_CERRAR_APP = " ¿Desea Salir del Sistema? ";
    public static String MENSAJE_FORMULARIO_ABIERTO = " ¡El formulario ya esta abierto! ";
}
