package org.adox.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ADOLFO
 */
public class testDateUtil {

    public static void main(String[] args) {

//            String inputDate = DateUtil.fechaHoraAplicacion(); //this from jsp   
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            java.util.Date myDt = sdf.parse(inputDate);
//            LogsUtil.Show(" ::: " +myDt);
            //        try {
            //            
            //            LogsUtil.Show(" ::: "+DateUtil.FechaHoraActualDate());
            //        } catch (Exception e) {
            //            LogsUtil.Show("Fallo operacion "+e.getMessage());
            //        }
                    Date ahora = new Date();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat formatoTiempo = new SimpleDateFormat("hh:mm:ss");
                    String fechaFormateada = formatoFecha.format(ahora);
                    String fechaFormatoTiempo = formatoTiempo.format(ahora);
                    System.out.println("formato de fecha " + formatoFecha.toPattern());
                    System.out.println("formato de tiempo " + formatoTiempo.toPattern());
                    System.out.println("fecha como cadena " + ahora.toString());
                    System.out.println("formato de fecha " + formatoFecha.toPattern() + " valor: " + fechaFormateada);
                    System.out.println("formato de fecha " + formatoTiempo.toPattern() + " valor: " + fechaFormatoTiempo);
            
            //        Date d1 = new Date();
            //        DateFormat[] dfa = new DateFormat[6];
            //        dfa[0] = DateFormat.getInstance();
            //        dfa[1] = DateFormat.getDateInstance();
            //        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
            //        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
            //        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
            //        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
            //        for (DateFormat df : dfa) {
            //        }
            //        }

            //        DateFormat df = DateFormat.getDateInstance();
            //        Date d = df.parse("09/02/2009");
            //        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            //        Date d = df.parse("09/02/09");
            //        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            //        Date d = df.parse("09/02/09");
            //        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
            //        Date d = df.parse("9 de febrero de 2009");
            //        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
            //        Date d = df.parse("lunes 9 de febrero de 2009");

    }
}
