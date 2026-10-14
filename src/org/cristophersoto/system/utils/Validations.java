package org.cristophersoto.system.utils;

public class Validations {

    public static final int MAX_ALUMNO = 50;
    public static final int MAX_EMPRESA = 50;
    public static final int MAX_TELEFONO = 15;

    public static boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean superaLongitud(String texto, int maximo) {
        return texto.trim().length() > maximo;
    }
}
