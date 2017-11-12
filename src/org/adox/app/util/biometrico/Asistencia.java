package org.adox.app.util.biometrico;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.adox.app.common.ConstantesApp;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;

public class Asistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        /*Date fechaActual = new java.util.Date();
         fechaActual = DateUtil.parsearFecha(DateUtil.fechaAplicacion(), "yyyy-MM-dd");
         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         String Fecha = formatter.format(fechaActual);
         System.out.println("Fecha : " + Fecha);*/

//        String dt = "2008-1-1";  // Start date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(sdf.parse(dt));
//        c.add(Calendar.DATE, -1);  // number of days to add
//        dt = sdf.format(c.getTime());
//
//        System.out.println("FECHAS " + dt);
//
//        String anio = String.valueOf(dt.split("-")[0]);
//        String mes = DateUtil.nombremes(Integer.valueOf(dt.split("-")[1]));
//
//        System.out.println("NOMBRE DE MES Y AÑO " + mes + " - " + anio);
//
//        String[] Puntualidad = new String[2];
//        int nroTardanza = 0;
//        String Asistencia = "0";
//        String minutos="01:31:12";
//        if (ConstantesApp.HORA_CERO.equals(minutos)) {
//            Asistencia = ConstantesApp.ASISTENCIA_PUNTUAL;
//            nroTardanza = 0;
//
//        } else {
//            String[] Tiempo = minutos.split(":");
//            int hora = Integer.parseInt(Tiempo[0]);
//            int minuto = Integer.parseInt(Tiempo[1]);
//            int segundo = Integer.parseInt(Tiempo[2]);
//            System.out.println( "DATOS HORA " + hora);
//            System.out.println( "DATOS MINUTO " + minuto);
//            System.out.println( "DATOS SEGUNDO " + segundo);
//            nroTardanza = hora*60 + minuto;
//        }
//
//        System.out.println( "MINUTOS DE TARDANZA " + nroTardanza);
//        System.out.println( "CALCULO ASISTENCIA " + Asistencia);        
        
        String Horario="L-V 9:00-18:00";
        System.out.println("FORMATO HORA "+horarioFormatoHora(Horario));        
    }
 
    public static String horarioFormatoHora(String horario){
        String[] Horarios=horario.split(" ");
        /*String Dias=Horarios[0];
        String hora=Horarios[1];
        String[] formatoTemp=Horarios[1].split("-");*/        
        String horaEntrada=Horarios[1].split("-")[0]+":00";        
        String horaSalida=Horarios[1].split("-")[1]+":00";        
        System.out.println(horaEntrada);
        System.out.println(horaSalida);        
        return horaEntrada;
    }
}
