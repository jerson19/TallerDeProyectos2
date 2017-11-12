package org.adox.app.util;

import javax.swing.ImageIcon;
import org.adox.app.config.AppConfigLocal;
import org.apache.log4j.Logger;

public class SplashScreenAlt implements Runnable {

    static Logger oClass = Logger.getLogger("SplashScreenUtil");
    SplashScreenAnt screen;
    Thread t;

    public SplashScreenAlt() {
    }

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        // initialize the splash screen
        splashScreenInit();
        // do something here to simulate the program doing something that
        // is time consuming
        for (int i = 0; i <= 100; i++) {
            //            for (long j = 0; j < 500000; ++j) {
            //                String poop = " " + (j + i);
            //            }
            try {
                t.sleep(40);
            } catch (InterruptedException ex) {
//                Logger.getLogger(SplashScreenUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            // run either of these two -- not both
            screen.setProgress("Cargando recursos al " + i + "%  ", i);  // progress bar with a message
            //screen.setProgress(i);           // progress bar with no message
        }
        splashScreenDestruct();
    }

    private void splashScreenDestruct() {
        screen.setScreenVisible(false);
    }

    private void splashScreenInit() {
        ImageIcon myImage = new ImageIcon(System.getProperty("user.dir") + AppConfigLocal.APP_LOGO);//org.adox.app.SplashScreenUtil.class.getClass().getResource("/org/adox/app/resources/imagenes/logo_visoft.png"));
        screen = new SplashScreenAnt(myImage);
        screen.setLocationRelativeTo(null);
        screen.setProgressMax(100);
        screen.setScreenVisible(true);
    }
//    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new SplashScreenUtil();
//    }
}
