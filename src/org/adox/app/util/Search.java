/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;

/**
 *
 * @author Adolfo
 */
class Search extends Thread {

    String startdir;        // directorio de busqueda
    String patt;            // lo que vamos a buscar
    JTextArea outarea;      // output area for file pathnames
    JFrame frame;           // frame
    JProgressBar progbar;   // barra de progreso
    JLabel fileslab;        // numero de ficheros encontrado
    boolean search_flag;    // true si la busqueda esta en progreso

    public Search(iProgressDemo aThis, JProgressBar progbar, JTextField dirfield, JTextField pattfield,
            String startdir, String patt) {
        frame = aThis;
        progbar = progbar;
        dirfield = dirfield;
        pattfield = pattfield;
        startdir = startdir;
        patt = patt;
    }
    // actualiza el GUI

    void doUpdate(Runnable r) {
        try {
            SwingUtilities.invokeAndWait(r);
        } catch (InvocationTargetException e1) {
            System.err.println(e1);
        } catch (InterruptedException e2) {
            System.err.println(e2);
        }
    }
    // nos da la lista de los ficheros de un directorio

    void getFileList(File f, List list) {

        // recursividad si hay un directorio dentro del mismo
        if (f.isDirectory()) {
            String entries[] = f.list();
            for (int i = 0; i < entries.length; i++) {
                getFileList(new File(f, entries[i]),
                        list);
            }
        } // para fciheros , se añaden a la lista y se actualiza la barra de progreso
        else if (f.isFile()) {
            list.add(f.getPath());
            final int size = list.size();
            if (size % 100 != 0) {
                return;
            }
            doUpdate(new Runnable() {

                public void run() {
                    progbar.setValue(size % 1000);
                }
            });
        }
    }

    // comprueba que el fichero contiene la cadena
    boolean fileMatch(String fn, String patt) {
        boolean found = false;

        try {
            FileReader fr = new FileReader(fn);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.indexOf(patt) != -1) {
                    found = true;
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return found;
    }

    // realiza la busqueda
    public void run() {
        List filelist = new ArrayList();
        final String sep =
                System.getProperty("line.separator");

        doUpdate(new Runnable() {

            public void run() {
                outarea.setText("");
                fileslab.setText("");
            }
        });

        // nos da la lista de todos los ficheros y muestra el contador
        getFileList(new File(startdir), filelist);
        final int size = filelist.size();
        doUpdate(new Runnable() {

            public void run() {
                progbar.setValue(0);
                fileslab.setText("Encontrados " + size
                        + " ficheros, buscando ...");
            }
        });

        // configura el monitor de progreso
        final ProgressMonitor pm = new ProgressMonitor(
                frame, "Buscando ficheros", "", 0, size - 1);
        pm.setMillisToDecideToPopup(0);
        pm.setMillisToPopup(0);

        // itera entre los ficheros, actualizando el monitor de progreso
        for (int i = 0; i < size; i++) {
            final String fn = (String) filelist.get(i);
            final int curr = i;
            if (pm.isCanceled()) {
                break;
            }
            final boolean b = fileMatch(fn, patt);
            doUpdate(new Runnable() {

                public void run() {
                    pm.setProgress(curr);
                    pm.setNote(fn);
                    if (b) {
                        outarea.append(fn + sep);
                    }
                }
            });
        }

        doUpdate(new Runnable() {

            public void run() {
                pm.close();
                outarea.setCaretPosition(0);
                fileslab.setText("");
            }
        });
        search_flag = false;
    }
}
