/*
 *
 */
package org.adox.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.adox.app.config.ServicioSpring;
import org.adox.app.facade.dao.facadeAplicacionDao;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 */
public class DateUtil {
    static Logger oClass = Logger.getLogger("DateUtil");

   public static String fechaAplicacion() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(anio) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia);
        return mifecha;
    }
   
   public static String fechaAplicacion2() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + " / " + nombremes(mes) + " / " + String.valueOf(anio);
        return mifecha;
    }
    
    public static String fechaAplicacionMasDias(int dias) {
        String fecha = fechaAplicacion();  // Start date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(fecha));
            c.add(Calendar.DATE, dias);  // number of days to add
            fecha = sdf.format(c.getTime());
        } catch (Exception e) {
            fecha=fechaAplicacion();
        }        
        return fecha;
    }
    
    public static String fechaHoraAplicacion() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static String HoraAplicacion() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Date FechaActualDate() throws ParseException {
        Date fechaActual = new java.util.Date();
        fechaActual = DateUtil.parsearFecha(DateUtil.fechaAplicacion(), "yyyy-MM-dd");
        return fechaActual;
    }

    public static Date FechaHoraActualDate() throws ParseException {
        Date fechaActual = new java.util.Date();
        fechaActual = DateUtil.parsearFechaHora(DateUtil.fechaHoraAplicacion(), "yyyy-MM-dd HH:mm:ss");
        return fechaActual;
    }

    public static Date FechaHoraActualDateAlternativo(){
        Date fechaActual = new java.util.Date();
        fechaActual = new java.sql.Date(fechaActual.getTime());
        return fechaActual;
    }

    public static String FechaActualString() throws ParseException {
        Date fechaActual = new java.util.Date();
        fechaActual = DateUtil.parsearFecha(DateUtil.fechaAplicacion(), "yyyy-MM-dd");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(fechaActual);
    }

    public static String fechaActualDDMMYYYY() throws ParseException {
        Date fechaActual = new java.util.Date();
        fechaActual = DateUtil.parsearFecha(DateUtil.FechaActualString(), "yyyy-MM-dd");
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(fechaActual);
    }

    public static DateFormat IrFormatoYYYYMMDD() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter;
    }

    public static DateFormat IrFormatoDDMMYYY() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter;
    }

    public static Date parsearFechaHora(String value, String pattern)
            throws ParseException {
        DateFormat formatter = new SimpleDateFormat(
                pattern == null ? "yyyy-MM-dd HH:mm:ss" : pattern);
        return formatter.parse(value);
    }

    public static Date parsearFecha(String value, String pattern)
            throws ParseException {
        DateFormat formatter = new SimpleDateFormat(
                pattern == null ? "yyyy-MM-dd" : pattern);
        return formatter.parse(value);
    }

    public static String fecha_DD_MES_YYYY() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + "/" + nombremes(mes) + "/" + String.valueOf(anio);
        return mifecha;
    }

    public static String fecha_YYYY_MM_DD() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(anio) + "/" + String.valueOf(mes) + "/" + String.valueOf(dia);
        return mifecha;
    }

    public static String fecha_DD_MES_YYYY_reporte() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + "_" + nombremes(mes) + "_" + String.valueOf(anio);
        return mifecha;
    }

    public static String fecha_DD_MM_YYYY_reporte() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + "_" + String.valueOf(mes) + "_" + String.valueOf(anio);
        return mifecha;
    }

    public static String Dia() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        return dia + "";
    }

    public static String Mes() {
        GregorianCalendar fecha = new GregorianCalendar();
        int mes = fecha.get(fecha.MONTH) + 1;
        return nombremes(mes).toUpperCase();
    }

    public static String Anio() {
        GregorianCalendar fecha = new GregorianCalendar();
        int anio = fecha.get(fecha.YEAR);
        return anio + "";
    }

    public static String nombremes(int mes) {
        switch (mes) {
            case 1:
                return "ENERO";
            case 2:
                return "FEBRERO";
            case 3:
                return "MARZO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAYO";
            case 6:
                return "JUNIO";
            case 7:
                return "JULIO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SEPTIEMBRE";
            case 10:
                return "OCTUBRE";
            case 11:
                return "NOVIEMBRE";
            case 12:
                return "DICIEMBRE";
        }
        return "error";
    }

    public static String Hora_HHMMSS_A() throws ParseException {
        //String fechaInicial = "08-08-2011 08:00:00";
        //String fechaFinal = "08-08-2011 09:02:00";        
        String mifecha = fechaActualDDMMYYYY();
        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return mifecha + " " + sdf.format(hoy);
    }

    public static String Hora_HHMMSS() throws ParseException {
        //String fechaInicial = "08-08-2011 08:00:00";
        //String fechaFinal = "08-08-2011 09:02:00";        
        String mifecha = fechaActualDDMMYYYY();
        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return mifecha + " " + sdf.format(hoy);
    }

    public static String formatoFechaYYYYMMDD(Date dt) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(dt);
    }

    public static String formatoFechaDDMMYYYY(Date dt) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dt);
    }

    public static String[] reporte_DiasMes(int year, int month) {
        String[] diasMes = new String[32];
        diasMes[0] = "";
        diasMes[28] = "";
        diasMes[29] = "";
        diasMes[30] = "";
        diasMes[31] = "";
        int numDays = 0;
        int today = 0;
        String days[] = {
            "D", "L", "M", "M", "J", "V", "S"
        };
        int daysMonth[] = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        String months[] = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        GregorianCalendar fec = new GregorianCalendar(year, month, 1);
        numDays = daysMonth[month];
        System.out.println("NRO DIAS DEL MES:" + numDays);
        /** Si es biciesto y es febrero le sumo uno al numero de dias */
        if (month == Calendar.FEBRUARY && fec.isLeapYear(year)) {
            numDays++;
        }
        today = fec.get(Calendar.DAY_OF_WEEK);
//        System.out.println("1er DIA DEL MES : " + days[today - 1]);
//        System.out.println("******* LISTA DE DIAS DEL MES ************");
        for (int i = 1; i <= numDays; i++) {
            fec = new GregorianCalendar(year, month, i);
            today = fec.get(Calendar.DAY_OF_WEEK);
//            System.out.println("DIA : " + i + " - " + days[today - 1]);
            diasMes[i] = "" + days[today - 1];
        }
        System.out.println("****************************************");

        return diasMes;
    }

    public static String RestarHoras(String fechaInicial, String fechaFinal) {
//pruebas 31-12-2008 09:45 && 09-04-2009 12:27 //hay 3 meses 9 dias 2 horas 41 minutos
        //String fechaInicial = "08-08-2011 08:00:00";
        //String fechaFinal = "08-08-2011 09:02:00";
        //System.out.println("año :"+fecha.substring(6,10));
        //System.out.println("dia :"+fecha.substring(0,2));
        //System.out.println("mes :"+fecha.substring(3,5));
        //System.out.println("hora :"+fecha.substring(11,13));
        //System.out.println("minuto :"+fecha.substring(14,16));
        //System.out.println("seg :"+fecha.substring(17,19));
        java.util.GregorianCalendar jCal = new java.util.GregorianCalendar();
        java.util.GregorianCalendar jCal2 = new java.util.GregorianCalendar();
        //jCal.set(year, month, date, hourOfDay, minute)
        jCal.set(Integer.parseInt(fechaInicial.substring(6, 10)), Integer.parseInt(fechaInicial.substring(3, 5)) - 1, Integer.parseInt(fechaInicial.substring(0, 2)), Integer.parseInt(fechaInicial.substring(11, 13)), Integer.parseInt(fechaInicial.substring(14, 16)), Integer.parseInt(fechaInicial.substring(17, 19)));
        jCal2.set(Integer.parseInt(fechaFinal.substring(6, 10)), Integer.parseInt(fechaFinal.substring(3, 5)) - 1, Integer.parseInt(fechaFinal.substring(0, 2)), Integer.parseInt(fechaFinal.substring(11, 13)), Integer.parseInt(fechaFinal.substring(14, 16)), Integer.parseInt(fechaFinal.substring(17, 19)));

        //System.out.println("Date format " + dateformat.format(jCal.getTime()) + "\n");
        //System.out.println("Date format " + dateformat.format(jCal2.getTime()) + "\n");

        long diferencia = jCal2.getTime().getTime() - jCal.getTime().getTime();
        double minutos = diferencia / (1000 * 60);
        long horas = (long) (minutos / 60);
        long minuto = (long) (minutos % 60);
        long segundos = (long) diferencia % 1000;
        long dias = horas / 24;
        //Calcular meses...
        //Crear vector para almacenar los diferentes dias maximos segun correponda
        String[] mesesAnio = new String[12];
        mesesAnio[0] = "31";
        //validacion de los años bisiestos
        if (jCal.isLeapYear(jCal.YEAR)) {
            mesesAnio[1] = "29";
        } else {
            mesesAnio[1] = "28";
        }
        mesesAnio[2] = "31";
        mesesAnio[3] = "30";
        mesesAnio[4] = "31";
        mesesAnio[5] = "30";
        mesesAnio[6] = "31";
        mesesAnio[7] = "31";
        mesesAnio[8] = "30";
        mesesAnio[9] = "31";
        mesesAnio[10] = "30";
        mesesAnio[11] = "31";
        int diasRestantes = (int) dias;
        //variable almacenará el total de meses que hay en esos dias
        int totalMeses = 0;
        int mesActual = jCal.MONTH;
        //Restar los dias de cada mes desde la fecha de ingreso hasta que ya no queden sufcientes dias para 
        // completar un mes.
        for (int i = 0; i <= 11; i++) {
            //Validar año, si sumando 1 al mes actual supera el fin de año, 
            // setea la variable a principio de año 
            if ((mesActual + 1) >= 12) {
                mesActual = i;
            }
            //Validar que el numero de dias resultantes de la resta de las 2 fechas, menos los dias
            //del mes correspondiente sea mayor a cero, de ser asi totalMeses aumenta,continuar hasta 
            //que ya nos se cumpla.
            if ((diasRestantes - Integer.parseInt(mesesAnio[mesActual])) >= 0) {
                totalMeses++;
                diasRestantes = diasRestantes - Integer.parseInt(mesesAnio[mesActual]);
                mesActual++;
            } else {
                break;
            }
        }
        //Resto de horas despues de sacar los dias
        horas = horas % 24;
        String salida = "";
        if (totalMeses > 0) {
            if (totalMeses > 1) {
                salida = salida + String.valueOf(totalMeses) + " Meses,  ";
            } else {
                salida = salida + String.valueOf(totalMeses) + " Mes, ";
            }
        }
        if (diasRestantes > 0) {
            if (diasRestantes > 1) {
                salida = salida + String.valueOf(diasRestantes) + " Dias, ";
            } else {
                salida = salida + String.valueOf(diasRestantes) + " Dia, ";
            }
        }
        salida = salida + String.valueOf(horas) + ":" + String.valueOf(minuto) + ":" + String.valueOf(segundos) + "";
        //System.out.println("" + salida);
        return salida;
    }
    
    public static void getFechaHora_Servidor_Cliente() {
        ServicioSpring aop = new ServicioSpring();
        facadeAplicacionDao service = (facadeAplicacionDao) aop.getBean("facadeAplicacionDao");
        String fechaHoraServidor = service.getObtenerFechaHoraServidor();
        String[] fechita = fechaHoraServidor.split(" ");
        String fechaServidor = fechita[0];
        String HoraServidor = fechita[1];        
        LogsUtil.Show(oClass,"fechaHoraServidor " + fechaHoraServidor);
        LogsUtil.Show(oClass,"fechaServidor " + fechaServidor);
        LogsUtil.Show(oClass,"HoraServidor " + HoraServidor);
        String cambiarFecha = "date" + " " + fechaServidor;
        CmdUtil.executeCmd(cambiarFecha);
        String cambiarHora = "time" + " " + HoraServidor;
        CmdUtil.executeCmd(cambiarHora);
        LogsUtil.Show(oClass,"getFechaHora_Servidor_Cliente() ::: Sincronización Exitosa");
    }

    public static void getFechaHora_Servidor_Cliente(String fechaHoraServidor) {
        String[] fechita = fechaHoraServidor.split(" ");
        String fechaServidor = fechita[0];
        String HoraServidor = fechita[1];        
        LogsUtil.Show(oClass,"fechaHoraServidor " + fechaHoraServidor);
        LogsUtil.Show(oClass,"fechaServidor " + fechaServidor);
        LogsUtil.Show(oClass,"HoraServidor " + HoraServidor);
        String cambiarFecha = "date" + " " + fechaServidor;
        CmdUtil.executeCmd(cambiarFecha);
        String cambiarHora = "time" + " " + HoraServidor;
        CmdUtil.executeCmd(cambiarHora);
        LogsUtil.Show(oClass,"getFechaHora_Servidor_Cliente() ::: Sincronización Exitosa");
    }
    
    public static String fechaAplicacionPanel() {
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH) + 1;
        int anio = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + " de " + nombremes(mes) + " del "+ String.valueOf(anio) ;
        return mifecha;
    }
}
