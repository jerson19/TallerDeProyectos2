package org.adox.app.util;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import org.adox.app.view.aplicacion.ifAsistencias;

public class RelojUtil extends Thread {

    JLabel reloj;

    public RelojUtil(JLabel reloj) {
        this.reloj = reloj;
    }
    //private Date hoy;

    public void run() {
        while (true) {
            Date hoy = new Date();
            //SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a") ;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar c = Calendar.getInstance();
            c.setTime(hoy);
            //c.add(Calendar.MINUTE, -10);
            String marcador = sdf.format(c.getTime());
            reloj.setText(marcador);
            ifAsistencias.lectorPrendido = Integer.valueOf(marcador.split(":")[0]);            
            //reloj.setText(sdf.format(hoy));
            //System.out.println("hora : " + ifAsistencias.lectorPrendido);
            try {
                sleep(1000);
            } catch (Exception ex) {
            };
        }
    }
}
