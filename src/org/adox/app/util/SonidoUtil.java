package org.adox.app.util;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class SonidoUtil {

    //objetos soportados
    private JTextField JTextfield;
    private JLabel jLabel;
    private JComboBox jComboBox;
    private JButton jButton;
    private String Tipo = "";
    private Clip clip;
    //paquete donde se encuentran los archivos de sonido WAV
    //private String path = "/org/adox/app/util/wav/";
    private String path = "sound/";

    public SonidoUtil(Object object) {
    }

    //metodo que reproduce un sonido del paquete WAV
    public void daleplay(String value) {
        try {
            clip = AudioSystem.getClip();
            //clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path + value + ".wav")));
            clip.open(AudioSystem.getAudioInputStream(new File(path + value + ".wav")));
            clip.start();
        } catch (Exception ex) {
            System.err.println("ERROR " + ex.getMessage());
        }
    }

}
