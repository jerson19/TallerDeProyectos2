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
public class test1 {

    /**
     * @param args the command line arguments
     */
    static Logger oClass = Logger.getLogger("test");

    public static void main(String[] args) {
        String stringCellValue = "232323.65";
        System.out.println(stringCellValue.trim().split("\\.")[0]);
        System.out.println(stringCellValue.trim().split("\\.")[1]);
        
    }
}
