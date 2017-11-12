package org.adox.app.util;

import org.adox.app.view.frmPrincipal;

/**
 * @author Adolfo
 */
public class ProgressUtil implements Runnable {

    public Thread progress;
    public static String estado = "0";

    public ProgressUtil() {
    }

    public synchronized void load() {
        progress = new Thread(this);
        progress.start();
    }

    public static boolean state() {
        boolean s = true;
        if (estado.equals("1")) {
            s = false;
        }
        return s;
    }

    public static void stop() {
        try {
            frmPrincipal.lblProgeso.setVisible(false);
            estado = "0";
        } catch (Exception e) {
            estado = "0";
        }
    }

    @Override
    public void run() {
        try {
            frmPrincipal.lblProgeso.setVisible(true);
            estado = "1";
        } catch (Exception e) {
            estado = "1";
        }
    }
}
