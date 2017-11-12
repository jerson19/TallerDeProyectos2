/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.awt.font.TextAttribute;

public class Marquesina extends JLabel {

    Hilo hilo;
    int x = 0;
    int y = 0;
    String texto = "";

    public Marquesina(String texto) {
        super(texto);
        hilo = new Hilo(this);
        setOpaque(true);
        setText(texto);
    }

    public Marquesina() {
        this("");
    }

    public void comenzar() {
        hilo.comenzar();
    }

    public void setText(String text) {
        texto = text;
    }

    public String getText() {
        return texto;
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(getFont());
        int anchoString = SwingUtilities.computeStringWidth(g.getFontMetrics(), texto);
        g2.drawString(texto, x, y);
        if (x <= 0) {
            derecha = true;
            //cambiarColor();
        }
        if (x + anchoString > getWidth()) {
            derecha = false;
            //cambiarColor();
        }
    }

    public void cambiarColor() {
        java.util.Random r = new java.util.Random();
        this.setForeground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        this.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
    }

    public void establecerTamaño(int ancho, int alto) {
        super.setPreferredSize(new Dimension(ancho, alto));
        this.x = this.getWidth();
        this.y = alto - (alto / 5);
        Font fuente = getFont();
        Map m = fuente.getAttributes();
        m.put(TextAttribute.SIZE, new Float((float) alto));
        setFont(new Font(m));
    }
    boolean derecha = true;

    private class Hilo extends Thread {

        Marquesina m;

        public Hilo(Marquesina m) {
            this.m = m;
        }

        public void comenzar() {
            this.start();
        }

        public void run() {
            try {
                while (true) {
                    if (derecha) {
                        x += 1;
                    } else {
                        x -= 1;
                    }
                    sleep(20);
                    m.repaint();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*public static void main(String args[]) {
        Marquesina m = new Marquesina();
        String texto = JOptionPane.showInputDialog("Digite el texto de la marquesina");
        m.setText(texto);
        m.establecerTamaño(500, 50);
        m.comenzar();
        JOptionPane.showMessageDialog(null, m);
        System.exit(0);
    }*/
}
