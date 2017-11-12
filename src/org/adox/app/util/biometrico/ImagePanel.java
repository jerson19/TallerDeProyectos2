package org.adox.app.util.biometrico;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author ADOLFO
 */
public class ImagePanel extends JPanel {
        //private PlanarImage image;

        private BufferedImage buffImage = null;

        public void drawFingerImage(int nWidth, int nHeight, byte[] buff) {
            buffImage = new BufferedImage(nWidth, nHeight, BufferedImage.TYPE_BYTE_GRAY);
            buffImage.getRaster().setDataElements(0, 0, nWidth, nHeight, buff);

            Graphics g = buffImage.createGraphics();
            g.drawImage(buffImage, 0, 0, null);
            g.dispose();
            setBackground(new java.awt.Color(51, 51, 51));
            repaint();
        }

        public void paintComponent(Graphics g) {
            g.drawImage(buffImage, 0, 0, this);
        }   
}
