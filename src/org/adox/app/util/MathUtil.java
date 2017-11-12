/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.math.BigDecimal;

/**
 *
 * @author ADOLFO
 */
public class MathUtil {

    public static BigDecimal MultiplicarBigDecimal(String Num1, String Num2) {
        BigDecimal Total = new BigDecimal("0.00");
        try {
            Total = (new BigDecimal(Num1)).multiply(new BigDecimal(Num2));
        } catch (Exception e) {
            Total = new BigDecimal("0");
        }
        return Total;
    }

    public static BigDecimal DividirBigDecimal(String Num1, String Num2) {
        BigDecimal Total = new BigDecimal("0.00");
        try {
            Total = (new BigDecimal(Num1)).divide((new BigDecimal(Num2)),2,BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {
            Total = new BigDecimal("0");
        }
        return Total;
    }

    public static BigDecimal SumarBigDecimal(String Num1, String Num2) {
        Double temp;
        BigDecimal Total = new BigDecimal("0");
        try {
            temp = (new BigDecimal(Num1)).doubleValue() + (new BigDecimal(Num2)).doubleValue();
            Total = new BigDecimal(""+temp);            
        } catch (Exception e) {
            Total = new BigDecimal("0");
        }
        return Total;
    }

    public static BigDecimal RestarBigDecimal(String Num1, String Num2) {
        Double temp;
        BigDecimal Total = new BigDecimal("0");
        try {
            temp = (new BigDecimal(Num1)).doubleValue() - (new BigDecimal(Num2)).doubleValue();
            Total = new BigDecimal(""+temp);            
        } catch (Exception e) {
            Total = new BigDecimal("0");
        }
        return Total;
    }
}
