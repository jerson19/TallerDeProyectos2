/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.poi.hssf.record.CalcCountRecord;

/**
 *
 * @author ADOLFO
 */
public class testFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int offset = 0;
        int numDays = 0;
        int today = 0;
        String days[] = {
            "DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SAB"
        };
        String months[] = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        int daysMonth[] = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        System.out.println("****************************************");
        System.out.println("********* PARA LA FECHA ACTUAL **********");
        System.out.println("****************************************");
        GregorianCalendar currCal = (GregorianCalendar) Calendar.getInstance();
        System.out.println("Año : " + currCal.get(Calendar.YEAR) + ", Mes : " + currCal.get(Calendar.MONTH) + ", Dia: " + currCal.get(Calendar.DAY_OF_MONTH) + " ");
        today = currCal.get(Calendar.DAY_OF_WEEK);
        System.out.println("DIA ACTUAL:" + days[today - 1]);
        System.out.println("****************************************");
        System.out.println("********* PARA CUALQUIER FECHA  **********");
        System.out.println("****************************************");
        int month = Calendar.JULY;
        int year = 2011;
        GregorianCalendar fec = new GregorianCalendar(year, month, 1);
        numDays = daysMonth[month];
        System.out.println("MES:" + month);
        System.out.println("NRO DIAS DEL MES:" + numDays);
        /** Si es biciesto y es febrero le sumo uno al numero de dias */
        if (month == Calendar.FEBRUARY && fec.isLeapYear(year)) {
            numDays++;
        }
        int today1 = 0;
        today1 = fec.get(Calendar.DAY_OF_WEEK);
        System.out.println("1er DIA DEL MES : " + days[today1-1]);        
        System.out.println("******* LISTA DE DIAS DEL MES ************");
        for (int i = 1; i <= numDays; i++) {
            fec = new GregorianCalendar(year, month, i);
            today1 = fec.get(Calendar.DAY_OF_WEEK);
            System.out.println("DIA : " +i+" - "+days[today1-1] );
        }
        System.out.println("****************************************");
    }
}
