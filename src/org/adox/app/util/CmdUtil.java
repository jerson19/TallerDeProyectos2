/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.adox.app.common.ConstantesApp;
import org.apache.log4j.Logger;

/**
 *
 * @author kr
 */
public class CmdUtil {

    static Logger oClass = Logger.getLogger("CmdUtil");
    /**
     * Retorna el volumen del disco duro
     * @return Volumen del disco duro
     */
    public String executeCommand() {
        // Definimos la cadena del interprete de comandos del sistema
        String commandShell = null;
        String str = ""; // variable k retorna el volumen
        String temp = "";
        // Recuperamos el sistema operativo
        commandShell = "cmd.exe /C " + "vol";
        // Lanzamos el proceso
        try {
            Process proc = Runtime.getRuntime().exec(commandShell);
            BufferedReader brStdOut = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader brStdErr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            while ((str = brStdOut.readLine()) != null) {
                temp += str;
            }
            brStdOut.close();
            brStdErr.close();
        } catch (IOException eproc) {
            System.out.println("Error to execute the command : " + eproc);
            return null;
        }
        return temp.substring(temp.indexOf("es: ")).substring(4);
    }

    public static void executeCmd(String ejecutar) {
        String comando = "cmd";
        try {
            Process proceso = Runtime.getRuntime().exec(comando);
            BufferedOutputStream out = new BufferedOutputStream(proceso.getOutputStream());
            out.write(ejecutar.getBytes());
            out.write("\r\n".getBytes());
            out.flush();
            out.close();
            proceso.waitFor();
            LogsUtil.LogsApp(oClass, ":: EJECUCION EXITOSA :: " + ejecutar, ConstantesApp.ERROR_INFO);
        } catch (IOException ex) {
            LogsUtil.LogsApp(oClass, ":: Error de I/O :: " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        } catch (InterruptedException ex) {
            LogsUtil.LogsApp(oClass, ":: ERROR :: " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        }
    }
}
