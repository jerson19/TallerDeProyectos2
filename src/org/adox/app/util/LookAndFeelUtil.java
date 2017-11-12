package org.adox.app.util;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.adox.app.common.ConstantesApp;
import org.apache.log4j.Logger;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

public class LookAndFeelUtil {

    static Logger oClass = Logger.getLogger("LookAndFeelUtil");

    public static void look() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            //UIManager.setLookAndFeel(ConstantesApp.LOOK_FEEL_SUBTANCE);
            LogsUtil.LogsApp(oClass, ConstantesApp.MSG_INFO_LOKK_FEEL_EXITOSO, ConstantesApp.ERROR_INFO);
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, ConstantesApp.MSG_INFO_LOKK_FEEL_FALLO, ConstantesApp.ERROR_INFO);
        }
    }

    public static void LookAndFeelSubtance() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(ConstantesApp.LOOK_FEEL_SUBTANCE);
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel");  
            LogsUtil.Show(oClass, "LookAndFeelSubtance Ok");
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, ConstantesApp.MSG_INFO_LOKK_FEEL_FALLO, ConstantesApp.ERROR_ERROR);
        }
    }

    public static void LookAndFeelAmarillo() {
        try {
            //UIManager.setLookAndFeel(ConstantesApp.LOOK_FEEL_SUBTANCE2);
            LogsUtil.Show(oClass, "LookAndFeelAmarillo Ok");
        } catch (Exception e) {
            System.out.println("Error de Look and Feel: Substance Raven Graphite failed to initialize");
        }
    }

    public static void LookAndFeelJava() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            LogsUtil.Show(oClass, "LookAndFeelJava Ok");
        } catch (Exception e) {
            System.out.println("Error de Look and Feel: Substance Raven Graphite failed to initialize");
        }
    }

    public static void LookAndFeelLetraCorrida() {
        try {
            UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
            LogsUtil.Show(oClass, "LookAndFeelJava Ok");
        } catch (Exception e) {
            System.out.println("Error de Look and Feel: Substance Raven Graphite failed to initialize");
        }
    }

    public static void lookBotonesRedondos(JButton oJButton) {
        try {
            //PARA BOTONOS REDONDOS
            oJButton.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
            UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error de Look and Feel: Substance Raven Graphite failed to initialize");
        }
    }
}
