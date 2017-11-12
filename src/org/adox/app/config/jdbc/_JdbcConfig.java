package org.adox.app.config.jdbc;

import java.sql.*;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.AppConfig;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;

public class _JdbcConfig {

    static Logger oClass = Logger.getLogger("_JdbcConfig");
    private static Connection oConnection;
    private static String JDBC_DRIVER;
    private static String JDBC_URL;
    private static String JDBC_USER;
    private static String JDBC_PASS;
    private static String JDBC_URL_INIT;
    private static java.util.ResourceBundle config;

    public _JdbcConfig() {
        init_jdbc();
    }

    public static void init_jdbc() {
        config = java.util.ResourceBundle.getBundle(AppConfigLocal.APP_PROPERTIES_JDBC);
        JDBC_DRIVER = config.getString("jdbc.driverClassName");
        JDBC_URL = config.getString("jdbc.url");
        JDBC_USER = config.getString("jdbc.username");
        JDBC_PASS = config.getString("jdbc.password");
        System.out.println("JDBC_DRIVER :: " + JDBC_DRIVER);
        System.out.println("JDBC_URL :: " + JDBC_URL);
        System.out.println("JDBC_USER :: " + JDBC_USER);
        System.out.println("JDBC_PASS :: " + JDBC_PASS);
    }

    /** Patron singleton **/
    public static Connection getConexion() {
        try {
            init_jdbc();
            Class.forName(JDBC_DRIVER);
            DriverManager.setLoginTimeout(12);
            _JdbcConfig.oConnection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            LogsUtil.Show(oClass, " Conexión JDBC Exitoso ");
        } catch (Exception ex) {
            //ex.printStackTrace();
            _JdbcConfig.oConnection = null;
            LogsUtil.LogsApp(oClass, "Fallo Conexión JDBC :: " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        }
        return oConnection;
    }

    /** Patron singleton **/
    public static boolean getTestConexion() {
        try {
            init_jdbc();
            Class.forName(JDBC_DRIVER);
            _JdbcConfig.oConnection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            LogsUtil.LogsApp(oClass, " Conexión JDBC Exitoso ", ConstantesApp.ERROR_INFO);
            _JdbcConfig.oConnection.close();
            return true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            _JdbcConfig.oConnection = null;
            LogsUtil.LogsApp(oClass, "Fallo Conexión JDBC :: " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
            return false;
        }
    }

    public void SetAutoCommit(boolean value) throws Exception {
        if (_JdbcConfig.oConnection == null) {
            return;
        }
        try {
            if (value == false) {
                _JdbcConfig.oConnection.setAutoCommit(false);
            } else {
                _JdbcConfig.oConnection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//metodo que sirve para inicializar toda una transaccion como ingresar una celula de produccion
    public static Connection beginTrans() {
        try {
            if (_JdbcConfig.oConnection == null) {
                throw new Exception();
            }
            if (_JdbcConfig.oConnection.getAutoCommit()) {
                _JdbcConfig.oConnection.setAutoCommit(false);
                return _JdbcConfig.oConnection;
            } else {
                return _JdbcConfig.oConnection;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //CUANDO LA TRANSACCION SE REALIZO CORRECTAMENTE SE LLAMA A ESTE METODO
    public static void commitTrans(Connection con) {
        try {
            con.commit();
            con.close();
        } catch (Exception e) {
            try {
                con.close();
            } catch (Exception ex) {
            }
        }
    }

    //CUANDO LA TRANSACCION SE REALIZO INCORRECTAMENTE SE LLAMA A ROLLBACK
    public static void rollbackTrans(Connection con) {
        try {
            con.rollback();
            con.close();
        } catch (Exception e) {
            try {
                con.close();
            } catch (Exception ex) {
            }
        }
    }
}
