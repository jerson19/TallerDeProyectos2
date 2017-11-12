/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

/**
 *
 * @author Edisoncor
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Edisoncor
 */
public class TextFieldValidador extends JTextField {

    private int arcw = 20;
    private int arch = 20;
    private Image image = null;
    private Icon icon;
    private Image info;
    private Image warn;
    private Image check;
    private Image error;

    public enum Estado {
        nada, precaucion, informacion, listo, error
    }
    
    private Estado estado = Estado.nada;

    public TextFieldValidador() {
        setOpaque(false);
        setBorder(new EmptyBorder(0, 5, 0, 7));
        setPreferredSize(new Dimension(100, 20));
        warn = loadImage("/org/adox/app/resources/validar/warn.png");
        info = loadImage("/org/adox/app/resources/validar/info.png");
        check = loadImage("/org/adox/app/resources/validar/check.png");
        error = loadImage("/org/adox/app/resources/validar/error.png");
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(TextFieldValidador.class.getResource(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight(), arcw, arch);
        g2.clip(r2d);

        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(),
                0.0f, getHeight(), getBackground()));
        g2.fillRoundRect(0, 0, getWidth() - 10, getHeight(), arcw, arch);
        if (getImage() != null) {
            g2.drawImage(getImage(), 5, 2, getHeight() - 3, getHeight() - 3, null);
            setBorder(new EmptyBorder(2, (int) (getHeight() * 1.2), 2, 12));
        }
        g2.setPaint(new GradientPaint(0.0f, 0.0f, Color.BLACK,
                0.0f, getHeight(), Color.BLACK));
        g2.drawRoundRect(0, 0, getWidth() - 10, getHeight() - 1, arcw, arch);

        Image imagen = null;
        switch (getEstado()) {
            case error:
                imagen = error;
                break;
            case informacion:
                imagen = info;
                break;
            case listo:
                imagen = check;
                break;
            case nada:
                imagen = null;
                break;
            case precaucion:
                imagen = warn;
                break;
            default:
                imagen = null;
        }

        if (imagen != null) {
            g2.drawImage(imagen, getWidth() - 15, getHeight() - 13,
                    13, 13, null);
        }

        g2.setPaint(oldPaint);
        super.paintComponent(g);

    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        repaint();
    }

    public int getArcw() {
        return arcw;
    }

    public void setArcw(int arcw) {
        this.arcw = arcw;
    }

    public int getArch() {
        return arch;
    }

    public void setArch(int arch) {
        this.arch = arch;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        setImage(((ImageIcon) icon).getImage());
    }
}
