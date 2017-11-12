/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.adox.app.common.ConstantesApp;
import org.apache.log4j.Logger;

/**
 *
 * @author ADOLFO
 */
public class test {

    /**
     * @param args the command line arguments
     */
    static Logger oClass = Logger.getLogger("test");

    public static void main(String[] args) {
        String minutos = "00:02:00";
        LogsUtil.Show(oClass, "TIEMPO TRANSCURRIDO " + minutos);
        String[] Puntualidad = new String[2];
        String[] Tiempo = minutos.split(":");
        int nroTardanza = 0;
        String Asistencia = "0";
        int hora = Integer.parseInt(Tiempo[0]);
        int minuto = Integer.parseInt(Tiempo[1]);
        int segundo = Integer.parseInt(Tiempo[2]);
        LogsUtil.Show(oClass, "DATOS HORA " + hora);
        LogsUtil.Show(oClass, "DATOS MINUTO " + minuto);
        LogsUtil.Show(oClass, "DATOS SEGUNDO " + segundo);
        if (hora == 0) {
            if (minuto > 0) {
                if (minuto <= 5) {
                    nroTardanza = 1;
                    Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    if (minuto == 5 && segundo > 0) {
                        nroTardanza = 2;
                        Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    }
                    LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
                }
                if (minuto > 5 && minuto <= 15) {
                    //LLEGO AL LIMITE DE LA 2° TARDANZA, ANTES DE 08:20:59
                    nroTardanza = 2;
                    Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    if (minuto == 15 && segundo > 0) {
                        nroTardanza = 3;
                        Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    }
                    LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
                }
                if (minuto > 15 && minuto <= 25) {
                    //LLEGO AL LIMITE DE LA 3° TARDANZA, ANTES DE 08:30:59
                    nroTardanza = 3;
                    Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                    if (minuto == 25 && segundo > 0) {
                        nroTardanza = 10;
                        Asistencia = ConstantesApp.ASISTENCIA_FALTA;
                    }
                    LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
                }
                if (minuto > 25) {
                    //EN ESTE PUNTO LLEGO TARDE SI O SI
                    nroTardanza = 10;
                    Asistencia = ConstantesApp.ASISTENCIA_FALTA;
                    LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
                }
            } else {
                nroTardanza = 0;
                Asistencia = ConstantesApp.ASISTENCIA_PUNTUAL;
                if (minuto == 0 && segundo > 0) {
                    nroTardanza = 1;
                    Asistencia = ConstantesApp.ASISTENCIA_TARDE;
                }
                LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
            }
        } else {
            //ASISTIO DESPUES DE UNA HORA
            nroTardanza = 10;
            Asistencia = ConstantesApp.ASISTENCIA_FALTA;
            LogsUtil.Show(oClass, "TARDANZA " + nroTardanza);
        }
        LogsUtil.Show(oClass, "MINUTOS DE TARDANZA " + nroTardanza * 10f);
        LogsUtil.Show(oClass, "CALCULO ASISTENCIA " + Asistencia);
        Puntualidad[0] = Asistencia;
        Puntualidad[1] = nroTardanza + "";
    }
}
