package org.adox.app.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * @author epsilon
 */
public class SplashScreenUtil implements ActionListener {

    void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"datos", "interfaz", "aplicacion"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, 280, 40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Cargando " + comps[(frame / 5) % 3] + "...", 120, 170);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (frame * 5) % 280, 10);
    }

    public SplashScreenUtil() {
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            JOptionPane.showMessageDialog(null, "SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            JOptionPane.showMessageDialog(null, "g is null");
            return;
        }

        for (int i = 0; i < 20; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }
        splash.close();
        try {
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}
