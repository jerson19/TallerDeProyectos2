/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADOLFO
 */
public class testHora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("xxx "+DateUtil.FechaActualString());
//            System.out.println("DateUtil.obtenerFecha_dd_MM_YYYY()  " + DateUtil.fechaActualDDMMYYYY()+" " + "07:00:00");
//            System.out.println("DateUtil.obtener_Fecha_Hora() " + DateUtil.Hora_HHMMSS_A());
//            String horas = DateUtil.RestarHoras(DateUtil.fechaActualDDMMYYYY() + " " + "07:00:00", DateUtil.Hora_HHMMSS_A());
//            System.out.println("HORAS  " + horas);
        } catch (ParseException ex) {
            Logger.getLogger(testHora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
