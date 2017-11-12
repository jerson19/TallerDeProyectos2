package org.adox.app.util;


import java.net.URL;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
/**
 * @author Adolfo
 */
public class LogsUtil {

    public static void LogsApp(Logger logger, String Mensaje, char tipoError) {
        URL url = Loader.getResource("log4j.properties");
        PropertyConfigurator.configure(url);
        try {
            switch (tipoError) {
                case 'D':
                    logger.debug(logger.getName() + " ===> " + Mensaje);
                    break;
                case 'I':
                    logger.info(logger.getName() + " ===> " + Mensaje);
                    break;
                case 'W':
                    logger.warn(logger.getName() + " ===> " + Mensaje);
                    break;
                case 'E':
                    logger.error(logger.getName() + " ===> " + Mensaje);
                    break;
                case 'F':
                    logger.fatal(logger.getName() + " ===> " + Mensaje);
                    break;
            }
        } catch (Exception e) {
            logger.fatal("Exepcion :: " + e.getMessage());
        }
    }

    public static void Show(Logger oLogger, String Descripcion) {
        LogsApp(oLogger, Descripcion, ConstantesApp.ERROR_INFO);
    }

    public static void Msg(Logger oLogger, String Mensaje, String Titulo, int MESSAGE) {
        LogsApp(oLogger, Mensaje, 'I');
        JOptionPane.showMessageDialog(null, Mensaje, Titulo, MESSAGE);
    }

}
