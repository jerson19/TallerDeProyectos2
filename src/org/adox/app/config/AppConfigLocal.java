package org.adox.app.config;

/**
 * @author AdolfoVillanueva
 */
public class AppConfigLocal {

    public static final String APP_LOGO = "\\logo.png";
    public static final String APP_ICONO = "adox.png";
    public static final String APP_PROPERTIES_JDBC = "jdbc";
    public static final String APP_PROPERTIES_RUTA = "/";
    public static final String APP_NAME = "Sistema de Asistencia Biométrica";
    public static final String APP_ID = "jdbc";
    public static final String APP_VERSION = "0.10";
    //REPORTES
    public static final String RUTA_RPTPERSONAL = "/Reportes/rptPersonal.jasper";
    public static final String RUTA_RPTLASISTENCIA = "/Reportes/rptAsistencias.jasper";
    public static final String RUTA_RPTLASISTENCIAMENSUAL = "/Reportes/rptAsistenciaMensual.jasper";
    public static final String RUTA_RPTPRODUCTIVIDAD = "/Reportes/rptProductividad.jasper";
    public static final String RUTA_RPTPRODUCTIVIDADRESUMEN = "/Reportes/rptProductividadResumen.jasper";
    // private static List<ResourceBundle> m_messages;
    private static AppLocaleResources m_resources;

    static {
        m_resources = new AppLocaleResources();
        m_resources.addBundleName("pos_messages");
        m_resources.addBundleName("erp_messages");
    }

    /** Creates a new instance of AppLocal */
    private AppConfigLocal() {
    }

    public static String getIntString(String sKey) {
        return m_resources.getString(sKey);
    }

    public static String getIntString(String sKey, Object... sValues) {
        return m_resources.getString(sKey, sValues);
    }
}
