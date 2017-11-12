package org.adox.app.util;

/*
 * Roger Masis Paniagua
 * 
 * Clase que codifica una imagen en un arreglo de bytes
 * Los formatos soportados son jpeg, png y gif
 */
public class ImagenBytes {

    //Constructor
    public ImagenBytes() {
    }

    /*
     * Metodo encardado ingresar la imagen en un java.io.InputStream
     */
    public byte[] crearImagen(String imagen) {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            java.io.InputStream in = cl.getResourceAsStream(imagen);
            byte[] data = new byte[99999];
            data = obtenerBytes(in, in.available());
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Devuelve el array de bytes
     */
    private static byte[] obtenerBytes(java.io.InputStream is, int capacidad) {
        java.io.DataInputStream dis = new java.io.DataInputStream(is);
        byte[] bytes = new byte[capacidad];//para la capacidad del array
        try {
            dis.readFully(bytes);//los bytes de la imagen son introducidos en el array "bytes"
            if (dis != null) {
                dis.close();//cierro el archivo
            }
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        return bytes;
    }

    public static void main(String[] args) {
        /**
         * imagenEnBytes, posee los bytes de una imagen ya codificada.
         * Se muestra en un JOptionPane.
         * ImagenIcon posee un costructor que admite un array de bytes
         */
        try {
            byte[] imagenEnBytes = {-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1, 1, 1, 0, 96, 0, 96, 0, 0, -1, -31, 0, 22, 69, 120, 105, 102, 0, 0, 73, 73, 42, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -37, 0, 67, 0, 8, 6, 6, 7, 6, 5, 8, 7, 7, 7, 9, 9, 8, 10, 12, 20, 13, 12, 11, 11, 12, 25, 18, 19, 15, 20, 29, 26, 31, 30, 29, 26, 28, 28, 32, 36, 46, 39, 32, 34, 44, 35, 28, 28, 40, 55, 41, 44, 48, 49, 52, 52, 52, 31, 39, 57, 61, 56, 50, 60, 46, 51, 52, 50, -1, -37, 0, 67, 1, 9, 9, 9, 12, 11, 12, 24, 13, 13, 24, 50, 33, 28, 33, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, -1, -64, 0, 17, 8, 0, 119, 0, 120, 3, 1, 34, 0, 2, 17, 1, 3, 17, 1, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -10, -22, 40, -94, -128, 10, 42, 25, -82, -19, -83, -104, 44, -9, 17, 68, 72, -56, 14, -31, 120, -4, 107, 39, 82, -15, 69, -123, -99, -84, -49, 12, -126, 105, 83, 32, 0, 14, -47, -18, 78, 57, 31, 78, -65, -88, 105, 55, -80, 27, -108, 87, -101, 77, -30, 59, -21, -72, 26, -19, -82, -26, -120, 30, -120, -115, -80, 0, 79, 76, 15, -1, 0, 95, 21, 115, 68, -15, -125, -38, -35, 71, 103, -88, -56, 100, -122, 71, 96, -109, 57, -53, 33, -50, 121, 61, -57, 63, 95, -27, 93, 15, 11, 81, 71, -104, -123, 52, -35, -114, -10, -118, -81, 30, -95, 101, 52, -126, 56, -81, 45, -28, 115, -47, 82, 85, 36, -2, 0, -43, -118, -26, -75, -117, 10, 76, 3, -40, 82, -47, 64, 9, -75, 125, 7, -27, 70, -43, -12, 31, -107, 45, 20, 0, -101, 71, -96, -91, -90, -55, 34, 67, 25, -110, 71, 84, 65, -43, -104, -32, 10, -55, 111, 20, 104, -88, -63, 90, -12, 2, 78, 48, 99, 111, 92, 122, 83, 73, -67, -128, -40, -94, -103, 20, -79, -49, 18, -53, 19, -121, 70, 25, 86, 29, 13, 20, -128, 125, 99, 107, -70, -4, 122, 52, 123, 68, 102, 89, -118, 23, -37, -48, 5, -25, -97, 126, 71, 79, -27, 91, 53, -27, -34, 54, -44, -4, -99, 90, -20, -121, 50, 42, -19, -115, 64, 57, 11, -14, -116, -113, 110, 115, -8, -43, -63, 39, 43, 49, -92, -34, -58, 126, -79, 44, -9, -118, 89, 37, 59, -25, 82, -18, 113, -115, -37, -86, -103, 70, 26, 11, 71, -97, -104, 41, -49, -3, -13, 85, 98, -43, 99, 119, -116, -71, -57, -56, 0, -10, -23, 94, -97, -91, 104, -106, 26, -82, -127, 11, 79, 105, 10, -106, 86, 1, -94, -7, 72, -49, 7, 56, -32, -32, -125, -41, 34, -67, 73, -54, -99, 42, 119, -118, -14, 57, -7, 36, -27, -85, 60, -94, 91, -121, 22, -111, 68, 14, -43, -32, -102, -44, -71, -73, 95, 42, -50, 85, -55, 102, 57, -3, 107, 91, 88, -16, 30, -91, 108, -95, -19, -95, 75, -108, 45, -73, 16, -100, 109, 92, -32, 18, -89, 7, 39, 60, -32, -100, 126, -75, -47, -24, 126, 11, -121, -5, 58, -39, -75, 116, 115, 58, 115, -27, 7, 24, 31, 82, 59, -3, 15, -91, 68, 113, 48, -27, -26, 111, -28, 90, -115, -102, 56, -119, 44, -99, -75, -100, 124, -89, 17, -125, -113, -58, -79, -46, 91, -8, -11, 25, 99, 83, 38, 19, 112, -37, -72, -32, 96, -29, -118, -12, -97, 18, 120, 126, -41, 75, 84, -44, 44, -14, -97, 48, 87, 70, 108, -15, -37, 4, -13, -41, -73, 61, 123, 98, -71, -39, 90, 29, -91, -14, -96, -114, -75, 116, 106, 70, -69, -77, 91, 10, 119, -126, -70, -22, 55, -61, -66, 40, -44, -20, 5, -49, -101, 52, -46, 71, 26, -16, -110, 57, 112, -72, -24, 0, 39, -89, -45, 21, -39, 90, 120, -5, 74, -67, -120, -55, 20, 55, 100, 14, -65, -69, 28, 126, -75, -26, -74, 51, 44, -74, -9, -14, 100, 16, -60, -32, -29, -73, 106, -46, -16, -107, -93, -35, -23, 109, 4, 10, 12, -49, 51, 70, 14, 56, -10, 39, 29, -121, 90, 43, 97, -23, 59, 50, 35, 57, 89, -98, -67, 12, -66, 116, 9, 46, -57, 77, -22, 27, 108, -125, 12, 51, -22, 59, 26, -60, -67, -15, -122, -101, 99, 113, 44, 50, 45, -61, 24, -104, -93, 20, 64, 70, -31, -40, 115, -21, -59, 111, -41, -102, 120, -82, 33, -3, -65, 119, 28, 106, -86, 93, -109, -96, -64, -55, 80, 127, 62, -65, -115, 121, 116, -30, -91, 53, 30, -25, 71, 71, 113, -70, -57, -118, 100, -42, 36, 85, -14, -38, 56, 19, -107, -116, 116, 13, -22, 79, 25, 63, -121, 79, -58, -79, 109, -79, 60, -78, 2, -93, 121, -112, 100, -97, -81, -1, 0, 90, -85, -49, 59, 90, 77, 36, 36, 12, -88, -2, -107, 118, -38, 34, -116, -114, 23, -8, -78, 86, -67, 72, -47, -89, 15, -124, -55, 78, 82, 59, 79, 4, -35, 60, -41, 115, 89, -32, -120, -42, 0, 79, -96, 101, -38, 6, 63, 2, 63, 42, 42, -113, -128, 37, -49, -119, 46, 16, 96, 110, -76, 36, -113, 112, -56, 63, -87, -94, -68, -6, -15, -76, -39, -94, 59, 123, -101, -104, 108, -19, -92, -72, -72, -111, 99, -118, 49, -106, 102, -24, 43, -61, 60, 77, 119, 107, 127, -81, -35, 61, -122, 86, -52, 63, -18, -105, 110, 57, -64, -55, 3, 28, 2, 114, 71, -79, -19, -46, -67, 75, -60, -110, 71, 125, 117, 30, -103, -112, 66, 39, -97, 47, -73, 96, 63, 92, -112, 123, 17, 94, 105, -83, -40, 65, 21, -53, 24, 64, 95, -100, -87, 3, -4, -5, 86, -40, 106, 42, 73, -66, -90, 51, -83, -53, 46, 84, 115, -70, 124, 45, 117, 112, 80, 28, 109, 93, -64, -111, -17, 94, -43, -32, 109, 90, 43, -35, 21, 109, 29, -93, 91, -85, 102, 100, 104, -61, 40, 102, 81, -113, -97, 104, -20, 119, 117, -11, -51, 121, -98, -99, 12, 22, -26, 54, 93, -96, -73, -54, 65, 61, -77, -1, 0, -42, -82, -13, -63, 126, 25, -65, -45, -75, 107, -115, 90, -16, 121, 73, 44, 38, 56, -31, 111, -67, -53, 6, -36, 127, -69, -45, -18, -42, -72, -102, 49, -123, 37, 119, -88, 66, -85, -100, -74, 59, -102, 40, -86, 90, -106, -81, 99, -92, -60, -78, 94, -36, 8, -107, -114, 7, 4, -25, -14, -81, 53, 43, -101, -107, -68, 73, 104, -73, 122, 37, -62, 54, 1, 69, 50, 6, -37, -100, 21, -25, -11, -58, 63, 26, -14, -99, 74, -46, 75, -104, -39, 21, 64, -58, -34, 15, 126, 51, -3, 5, 122, 14, -77, -30, 29, 43, 82, -45, -34, -58, -42, -20, 53, -60, -91, 74, 41, 70, 25, -61, 2, 122, -113, 64, 107, -108, 72, -4, -51, 71, 85, 98, 115, -13, 43, 32, 61, 7, 4, 127, 74, -12, 112, 81, -108, 92, -100, -106, -106, 50, -85, 59, 43, 28, -34, -105, 4, 107, -94, -88, 80, 67, 54, 123, 117, 27, -85, -84, -8, 119, 17, -114, -6, 85, -56, 11, 28, -20, 48, 70, 58, -87, -11, -83, -5, -49, 15, 53, -57, -124, 52, -43, 88, 15, -37, -83, 45, -94, 82, 54, -4, -60, 5, 27, -105, -6, -6, -15, -127, -42, -80, 124, 63, -120, 6, -80, 73, -7, 75, -28, 126, 70, -76, -10, -86, -83, 38, -106, -28, 73, -72, 106, 122, 84, -46, -91, -68, 18, 77, 33, -60, 113, -87, 102, 56, -24, 5, 120, -5, -35, 79, 119, -84, 27, -103, -25, 105, 24, 97, -114, 121, -53, 54, -31, -6, 1, -116, 86, -108, -34, 33, -71, -67, -46, 99, -45, 46, 46, -73, 73, 18, -107, 124, 54, 90, 82, 15, 86, 62, -61, -13, 35, 38, -78, -76, 29, 34, -5, 82, -44, -89, -74, -74, -124, -76, 105, -80, 51, -79, -38, -88, -68, -29, 39, -15, 28, 123, 26, -50, -123, 21, 74, -13, -87, -48, 114, -87, -52, -83, 18, -61, 64, -9, 19, 92, 78, -111, 51, -94, 109, -34, -31, 120, 92, -128, 6, 79, 106, 84, -103, 69, -22, -95, 32, 2, 6, 7, -25, -97, -23, 82, -8, -126, -12, 91, 91, -115, 3, 79, -116, 71, 21, -69, -111, 35, -29, 13, 44, -128, 97, -100, -11, -4, 61, -65, 12, 96, -107, -106, 73, -83, -100, -27, 88, -80, 25, 25, -11, -82, -107, 41, 73, 93, -83, 58, 19, -54, -106, -121, -87, 120, 63, 66, 75, 11, -121, -44, -35, -97, 124, -47, -7, 113, -81, 96, -121, 105, -55, -4, 87, -113, 106, 43, -95, -46, -83, -38, -38, -54, -38, -34, 86, 14, -16, -62, -88, -52, 58, 18, 0, 25, -94, -68, -103, -55, -54, 87, 103, 66, 86, 56, -19, 73, -42, 47, 22, 95, 100, -14, -42, -63, -128, 63, 65, -2, 21, -25, -102, -17, 23, 45, 39, 42, 76, -84, -28, -125, -45, -97, -2, -67, 118, 94, 42, -110, 84, -15, -94, -104, -58, 84, -38, -19, 108, 118, -17, -4, -85, -115, -44, -30, -110, -31, 39, 98, -128, 96, 12, 100, 123, -118, -12, -16, -54, -16, -26, 93, -65, 35, -110, 112, -3, -27, -56, 116, -56, 30, -13, 83, -76, -121, -51, 10, -66, 114, 111, 98, 71, -56, -92, -14, 78, 126, -107, -17, -101, -44, 117, 97, -7, -41, -118, 105, 48, -117, 123, -88, 28, -32, 124, -83, -110, 59, -11, -86, 90, -100, 115, -101, -37, -103, -94, -72, 117, 77, -7, 8, 24, -116, 82, -60, 97, -91, 86, -51, 14, 53, 57, 29, -113, 107, 58, -42, -106, -67, 117, 27, 79, -5, -4, -65, -29, 92, 55, -115, 117, -53, 13, 94, -34, 43, 91, 39, 18, 21, -7, -52, -123, 8, 42, 123, 1, -100, 31, 115, -8, 87, -102, -62, -109, 77, 20, -88, -52, -50, -28, -111, -71, -114, 79, 111, 90, -109, 78, -74, -44, 77, -37, -59, 111, 111, 53, -61, -3, -47, 28, 72, 88, -9, -12, 30, -126, -78, -91, -121, 84, -28, -91, 61, -115, 121, -36, -82, -111, 114, 45, 72, -1, 0, 106, 64, 6, -19, -23, -128, 120, -17, -100, 87, 103, -31, 75, 75, -101, -65, 20, -54, -26, 55, 88, 99, 101, -110, 70, 4, 13, -72, 44, 71, -73, 36, 99, -114, -64, -42, 94, -105, -32, 45, 102, -18, 107, 73, -90, -123, 109, 19, 122, -68, -115, 55, -34, -64, 60, -116, 117, -49, -41, 3, -114, -75, -22, 90, 94, -111, 111, -91, -85, -104, -78, 101, -112, 15, 49, -49, -15, 99, 56, -29, -73, 83, 90, -41, -59, 70, 48, 113, -117, -69, 98, 84, -17, 43, -78, -43, -35, -44, 118, 86, -110, 92, -54, 28, -92, 107, -72, -124, 82, -57, -14, -81, 49, -66, -43, -32, -65, -72, -44, -82, -20, -83, -38, 36, 112, 75, 35, 17, -106, 97, -58, -20, 1, -41, -44, 125, 122, -12, -81, 84, 35, 35, 6, -78, 101, -16, -58, -115, 51, -105, 107, 21, 4, -11, 8, -52, -93, -14, 4, 10, -13, -24, -44, 84, -27, 118, 105, 56, -13, 43, 30, 47, -94, -55, -10, -83, 117, -43, -105, -99, -49, -111, -114, -126, -67, 43, -62, 90, -107, -115, -91, -35, -26, -98, 99, 104, -25, 105, 84, -7, -100, 16, -28, -114, 7, 3, 35, -127, -98, 73, -22, 121, -24, 43, 98, 31, 7, -24, 22, -14, -76, -80, -23, -56, -114, -35, 89, 93, -127, 63, -83, 95, -76, -46, 52, -5, 25, 12, -106, -10, -111, 36, -92, -28, -56, 70, -25, -23, -113, -68, 121, -23, 90, -43, -60, -86, -111, -77, 68, -58, -101, 78, -24, -13, -65, 18, 89, -75, -122, -77, 121, 60, -53, -9, -28, 50, 2, 1, -28, 49, -56, -19, -8, 126, 6, -71, -92, 50, -69, -37, -25, -116, 54, 87, 28, -15, -59, 122, -73, -116, 44, -110, -25, 68, 105, -104, -31, -96, 60, 123, -122, -64, 35, -7, 31, -62, -68, -11, -94, 65, 44, 41, 16, -55, 94, 49, -113, -91, 117, 97, 106, 41, -61, -107, -12, 34, -94, -110, 119, 71, -84, -24, 122, -121, -10, -114, -99, 109, 118, 87, 97, -107, 126, 117, -20, 24, 112, 113, -19, -112, 104, -84, 95, 6, -35, -76, -102, 124, -74, -52, -84, -83, 111, 39, 25, -57, 70, 25, -2, 121, -94, -68, -22, -111, -28, -109, -119, -78, 119, 87, 15, 20, -39, 46, -40, 117, 16, -71, -14, 126, 73, 121, -2, 19, -48, -2, 4, -10, -11, -10, -81, 40, -44, 117, 85, 50, -51, 4, 113, -114, 72, -7, -77, -45, -95, -81, 118, -98, 24, -18, 96, 120, 102, 64, -15, -72, -61, 41, 28, 17, 95, 60, -34, -38, 60, 58, -99, -52, 12, -69, 30, 41, -38, 50, -67, 112, 65, -57, 90, -23, -62, -43, 105, 56, -93, 58, -119, 94, -20, -17, 60, 35, -91, 69, 127, -85, 91, -101, -107, 45, 20, 80, 60, -69, 59, 49, -36, 0, 7, 61, 71, 36, -2, 21, 47, -116, -68, 58, 52, -30, 46, 109, 19, 22, 82, 46, -46, -69, -78, 81, -1, 0, 30, 112, 64, -9, -25, 61, -115, 30, 17, -120, -57, -84, -23, -118, 122, -84, 108, 15, -3, -16, 107, -65, -44, 116, -5, 125, 78, -58, 75, 91, -104, -9, -58, -29, -73, 5, 79, -88, 61, -115, 93, 106, -14, -89, 93, 73, 61, -120, -124, 84, -23, -76, 120, -105, -125, -18, -110, -41, -60, 114, 61, -59, -94, -36, 91, 35, 54, -11, 101, 4, -29, -89, 0, -9, -17, 94, -39, -89, -117, 38, -76, 73, 108, 35, -119, 33, -109, -26, 30, 90, 5, 7, -16, -81, 28, -79, -80, -109, 72, -15, 21, -11, -124, -56, 4, -111, 3, -110, 14, 114, 9, 4, 31, -60, 16, 107, 106, -37, 84, -65, -45, 101, 79, -79, 92, -78, 43, -77, 111, 92, 101, 122, 47, 99, -64, 60, 117, -83, 42, 81, -10, -15, 82, -114, -31, 26, -100, -114, -52, -11, 74, 43, -49, 116, -1, 0, 26, 106, 54, -38, -84, -112, -22, 8, 46, 45, -114, 2, -107, 1, 93, 15, 126, -128, 6, -17, -7, 87, -95, 87, -97, 82, -108, -87, -69, 72, -34, 50, 82, 87, 65, 69, 20, 86, 101, 5, 20, 81, 64, 24, 94, 44, -71, 72, 116, 86, -123, -74, -106, -99, -43, 64, 39, -96, 7, 57, -57, 126, 64, 31, -120, -81, 57, 12, 45, -75, 32, -92, 2, 92, -73, 67, -56, -82, -81, -57, -50, -48, -51, 98, -2, 99, 17, 46, 80, 71, -114, 6, 24, 18, 127, 28, -113, -54, -71, -92, 80, -41, 37, -56, -53, -110, -64, 19, -44, 87, -87, -124, -118, 84, -36, -116, 42, 54, -35, -114, -61, -63, -101, -115, -43, -29, 8, -104, 71, 42, -87, 105, 79, 64, -53, -4, 63, 92, 54, 127, 10, 43, 123, 68, -74, -110, -45, 70, -74, -122, 81, -121, 11, -110, 49, -116, 100, -109, -113, -81, 52, 87, -97, 86, 124, -45, 108, -42, 49, -27, 86, 44, -36, -35, -37, -39, -60, 100, -72, -103, 35, 80, 9, -7, -113, 39, 29, 112, 59, -2, 21, -32, -9, -79, 73, 123, -85, 92, -36, 23, 33, -26, -99, -92, 56, -11, 38, -67, -77, 91, -76, -118, -29, 79, -106, 73, 35, -34, -47, 35, 17, -50, 56, -18, 63, 79, -46, -68, -58, -10, -63, 44, -18, -91, -29, 7, -100, 115, -110, 71, 81, 93, 120, 74, 113, -110, 111, -87, -107, 86, -17, 99, 103, -62, -101, -65, -73, -83, 3, 14, 64, 112, 63, -17, -125, 94, -113, 94, 91, -31, -30, -58, -6, -59, -13, -55, -99, 70, 125, -73, -30, -67, 74, -71, -15, 18, -26, -88, -39, 116, -29, -53, 27, 28, 119, -116, -76, 116, 107, -120, 117, -108, -112, -119, -107, 68, 12, -100, 97, -105, 59, -72, -23, -56, -25, -41, -12, -81, 61, -110, -10, 91, 105, 14, -44, 12, 12, -116, -64, -97, 112, 43, -37, -25, -126, 59, -104, 90, 25, -112, 50, 48, -63, 6, -68, -105, -60, -38, 28, -102, 110, -86, 2, -88, -14, -119, 44, 78, -32, 119, 41, -5, -89, -89, 94, 48, 125, -1, 0, 58, -21, -62, 87, -76, 121, 58, -111, 82, -102, 110, -28, -102, 33, -5, 102, -85, 19, -54, -127, -125, 92, 70, -124, 17, -112, 70, 70, 69, 122, -43, 120, -3, -100, -79, -93, -76, 101, -108, 101, -78, 57, 29, 120, -81, 76, -48, 47, 77, -26, -104, -98, 99, -77, 77, 31, -54, -27, -70, -97, 67, -7, 127, 35, 89, 99, 19, -25, -69, 29, 22, -83, -95, -87, 69, 20, 87, 17, -80, 82, 51, 5, 82, -52, 64, 3, -87, 39, -91, 45, 35, 42, -70, -107, 101, 12, -89, -126, 8, -32, -48, 7, -101, -21, 122, -113, -10, -58, -68, -28, 49, -14, 45, -64, -114, 48, 9, 32, -14, 114, -40, 61, 9, -29, -14, 30, -107, -101, 108, -59, -11, 25, -45, 102, 82, 50, 72, 108, 119, -29, -1, 0, -81, 87, 53, -99, 54, 93, 47, 83, -108, -57, 19, 42, 59, 99, 39, -72, -55, -38, -36, 122, -25, -13, 20, -19, 62, -45, -54, 18, 51, 125, -23, 8, 99, -57, -83, 122, 46, 107, -40, -38, 27, 24, 109, 45, 79, 77, -94, -96, -77, 37, -84, 109, -40, -11, 49, -87, 63, -107, 21, -25, 27, -113, -72, -110, 24, -83, -35, -18, 25, 22, 32, 62, 98, -29, 35, 30, -29, -65, -46, -68, -61, 86, -59, -60, -47, 58, -14, 10, -128, 78, 49, -109, -21, 94, -101, 113, 107, 111, 116, -95, 110, 33, -114, 80, 58, 111, 80, 113, 84, -27, -16, -2, -105, 50, -123, 123, 69, -64, 57, 27, 89, -105, -7, 26, -21, -61, -41, -115, 36, -17, 123, -77, -102, -75, 58, -77, -110, -27, -75, -65, 19, -127, -46, 25, 109, 68, 83, -29, 114, -37, -49, -110, 9, -58, 112, 119, 87, -93, -39, 95, -37, -33, -59, -26, 91, -55, -69, 24, -36, -89, -126, -65, 81, 85, 23, -61, -70, 74, -95, 69, -77, 80, -89, -88, 14, -36, -2, -75, 102, -41, 76, -77, -78, -112, -67, -76, 1, 25, -122, 9, -55, 60, 126, 53, -123, 73, 70, 78, -24, -38, 42, 75, 114, -35, 83, -44, 116, -37, 125, 78, -40, -61, 58, -125, -113, -70, -40, -28, 26, -71, 69, 66, 109, 59, -94, -49, 40, -41, 124, 29, 46, -101, -105, -38, 76, 68, -16, 73, -56, 31, -3, 106, -71, -92, -8, -126, 77, 55, 100, -46, 109, 86, 63, -69, 46, 70, 84, -13, -33, -45, -112, 63, -3, 85, -24, -13, 65, 21, -62, 108, -98, 36, -107, 63, -70, -22, 24, 126, -75, -98, 124, 55, -93, -104, -68, -93, -89, -62, 83, -5, -89, 56, -82, -103, 87, -116, -29, 105, 45, 76, -44, 26, -22, 46, -97, -82, 89, -22, 17, -60, 86, 69, 89, 36, 56, 10, 9, 35, 63, -17, 99, 6, -76, -22, -107, -90, -111, 97, 96, -54, 109, 109, -110, 45, -71, -37, -73, 56, 25, -21, -59, 93, -82, 103, 110, -123, -85, -11, 10, 40, -94, -112, -50, 83, -59, -45, 68, -116, -120, -50, -69, -39, 84, 5, 3, 39, -122, -55, -6, 86, 84, 36, -69, -127, -125, -9, 6, 56, -82, -50, -13, 72, -80, -65, 96, -41, 54, -88, -20, 58, 55, 42, 127, 49, -51, 87, 30, 30, -78, 67, -14, 121, -119, -58, 0, 12, 56, -4, -59, 110, -86, 37, 30, 82, 57, 93, -18, 46, -111, -87, 69, 115, 20, 118, -63, 28, 73, 28, 124, -98, -86, 113, -127, -41, -41, -89, 20, 85, -85, 93, 62, -38, -52, -122, -122, 61, -83, -73, 110, -20, -98, 69, 21, -127, 101, -86, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 10, 40, -94, -128, 63, -1, -39};
            javax.swing.JOptionPane.showMessageDialog(null, "Asi se mira la imagen", "Prueba",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE,
                    new javax.swing.ImageIcon(imagenEnBytes));

        } catch (Exception fnfe) {
            fnfe.printStackTrace();
        }
        /*
         * Para realizar una codificacion
         */
        try {
            ImagenBytes ib = new ImagenBytes();
            byte[] imagenEnBytes =//Almacena el array de bytes de la imagen
                    ib.crearImagen(//se llama al metodo que codifica la imagen
                    "tu.jpeg");//debe de escribie el nombre y la extesion de la imagen a codificar, Formatos soprtados por java.awt.Toolkit: jpeg, png, gif
            javax.swing.JOptionPane.showMessageDialog(null, "Asi se mira la imagen", "Prueba",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE,
                    new javax.swing.ImageIcon(imagenEnBytes));

        } catch (Exception fnfe) {
            fnfe.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "No ha introducido una imagen valida.\nEjemplo: prueba.jpg", "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE,
                    null);

        }
    }
}