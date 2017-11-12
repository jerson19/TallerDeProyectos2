package org.adox.app.util;

import java.awt.event.*;

public class ValidadoresUtil {

    static public KeyEvent e;
    static char a;

    public static void validarNumero(KeyEvent e) {
        e = e;
        char a = e.getKeyChar();

        if (!(a >= KeyEvent.VK_0 && a <= KeyEvent.VK_9)) {
            e.consume();
        }
    }

    public static void validarNumeroDouble(KeyEvent oKeyEvent) {
        e = oKeyEvent;
        char a = e.getKeyChar();
        if (!(a >= KeyEvent.VK_0 && a <= KeyEvent.VK_9 || a == '.')) {
            e.consume();
        }
    }
    
    public static boolean validaNum(String Valor) {
        try {
            Integer.parseInt(Valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarDouble(String Valor) {
        try {
            Double.parseDouble(Valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
