package org.adox.app.util;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
//import javax.media.Manager;
//import javax.media.Player;

public class RepSonidoUtil {

    //private Player mediaPlayer;
//control
    boolean run = false;
    boolean todo_ok = false;
//archivo
    URL mediaURL = null;
    String file = "";
//otros
    String t = null;
    Clip sonido;

    public RepSonidoUtil() {
    }

    public void ReproducirMP3(String URLMusica) {
        try {
            if (todo_ok) {
                this.StopMP3();
            }
            //mediaPlayer = Manager.createPlayer(getClass().getResource("/org/sic/app/resources/"+URLMusica));
            //se coloca a true
            this.todo_ok = true;
        } catch (Exception ev) {
            System.out.println("Nose encontro el mp3");
        }
    }

    public String PlayMP3() {
        t = "No existe ningun archivo...";
       /* if (todo_ok) {
            if (!run) {//si ya se esta reproduciendo
                mediaPlayer.start();
                this.run = true;
                t = "Reproduciendo";
            }
        }*/
        return t;
    }

    public String StopMP3() {
//comprueba que el reproductor tenga un archivo
       /* if (todo_ok) {
            mediaPlayer.stop();
            this.todo_ok = false;
            this.run = false;
            this.file = "";
//            this.stopAnimation();
        }*/
        return "Reproductor mp3 - by Mouse";
    }

    public void ReproducirWAV(String URLMusica) {
        try {
            sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File(URLMusica)));

        } catch (Exception ev) {
            System.out.println("Nose encontro el wap");
        }
    }

    public void PlayWAV() {
        sonido.loop(0);
    }

    public void PlayContinueWAV() {
        sonido.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void StopWAV() {
        sonido.stop();
    }
}
