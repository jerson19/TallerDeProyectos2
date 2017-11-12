package org.adox.app;

import javax.swing.SwingUtilities;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.ServicioSpring;
import org.adox.app.facade.business.dto.UsuarioSesion;
import org.adox.app.facade.business.facadeNegocioBusiness;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.LookAndFeelUtil;
import org.adox.app.util.SonidoUtil;
import org.adox.app.view.frmLogin;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public class Main {

    static Logger oClass = Logger.getLogger("Main");

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        LogsUtil.LogsApp(oClass, ConstantesApp.MSG_INFO_INICIO_APP, ConstantesApp.ERROR_INFO);
        //ACA SE APICA EL LOOK AND FIELD
        LogsUtil.LogsApp(oClass, " Preparando para cargar Look and field ", ConstantesApp.ERROR_INFO);

        switch (ConstantesApp.LOOK_AND_FEEL.charAt(0)) {
            case '0':
                LookAndFeelUtil.look();
                break;
            case '1':
                LookAndFeelUtil.LookAndFeelJava();
                break;
            case '2':
                LookAndFeelUtil.LookAndFeelAmarillo();
                break;
            case '3':
                LookAndFeelUtil.LookAndFeelSubtance();
                break;
            case '4':
                LookAndFeelUtil.LookAndFeelLetraCorrida();
                break;
            default:
                LookAndFeelUtil.LookAndFeelJava();
                break;
        }
        //REPRODUCCION DE SONIDO
        SonidoUtil sonido = new SonidoUtil(oClass);
        sonido.daleplay(ConstantesApp.SONIDO_INICIO);


        if (ConstantesApp.TIPO_APP.compareTo("1") == 0) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    ServicioSpring aop = new ServicioSpring();
                    facadeNegocioBusiness oNegocioBuss = (facadeNegocioBusiness) aop.getBean("facadeNegocioBusiness");;
                    UsuarioSesion obj = oNegocioBuss.getValidarLogeo("adolfo", "vill@", "1");
                    frmPrincipal ofrmPrincipal = new frmPrincipal(obj, this);
                }
            });

        }
        
        if (ConstantesApp.TIPO_APP.compareTo("2") == 0) {
            //INICIALIZA LOGIN
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    frmLogin ofrmLogin = new frmLogin();
                    ofrmLogin.setVisible(true);
                    ofrmLogin.setLocationRelativeTo(null);
                }
            });
        }
    }
}
