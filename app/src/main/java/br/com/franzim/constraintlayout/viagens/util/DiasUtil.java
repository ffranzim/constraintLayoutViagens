package br.com.franzim.constraintlayout.viagens.util;

public class DiasUtil {

    public static final String DIA_PLURAL = " dias";
    public static final String DIA_SINGULAR = " dia";

    public static String formataDiasEmTexto(int dias) {

        if (dias > 1) {
            return dias + DIA_PLURAL;
        }
        return dias + DIA_SINGULAR;
    }
}
