/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

/**
 *
 * @author kr
 */
public class EncriptarUtil {

    String patronBusqueda = "3KB4ACHJDELRQIPWiSVTNÑjkZabXYlmhefcdgnqrsñoptyz1vwx2678FG5OM90";
    String patronEncripta = "XYlptymhcdgefnqrz6781sñovwxB4AC2FG5OM90DEL3KHJRQISVTNPWiÑjkZab";

    public String encriptaCadena(String cadena) {
        String temp = "";
        for (int i = 0; i < cadena.length(); i++) {
            temp += encriptaCaracter(String.valueOf(cadena.charAt(i)), cadena.length(), i);
        }
        return temp;
    }

    private String encriptaCaracter(String caracter, int variable, int indice) {
        String tmp = "";
        int index;
        if (patronBusqueda.indexOf(caracter) != -1) {
            index = (patronBusqueda.indexOf(caracter) + variable + indice) % patronBusqueda.length();
            return String.valueOf(patronEncripta.charAt(index));
        }
        return caracter;
    }

    public String desencriptaCadena(String cadena) {
        String temp = "";
        for (int i = 0; i < cadena.length(); i++) {
            temp += desencriptaCaracter(String.valueOf(cadena.charAt(i)), cadena.length(), i);
        }
        return temp;
    }

    private String desencriptaCaracter(String caracter, int variable, int indice) {
        int index;
        if (patronEncripta.indexOf(caracter) != -1) {
            if ((patronEncripta.indexOf(caracter) - variable - indice) > 0) {
                index = (patronEncripta.indexOf(caracter) - variable - indice) % patronEncripta.length();
            }
            else{
                index = patronBusqueda.length() + (patronEncripta.indexOf(caracter) - variable - indice) % patronEncripta.length();
            }
            index = index % patronEncripta.length();
            return String.valueOf(patronBusqueda.charAt(index));
        }
        return caracter;
    }
}
