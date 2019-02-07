package br.com.franzim.constraintlayout.viagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String getPeriodoEmTexto(Calendar dataInicial, int dias) {
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(dataInicial.DATE, dias);

        SimpleDateFormat sdf = new SimpleDateFormat(DIA_MES);
        return sdf.format(dataInicial.getTime()) + " - " + sdf.format(dataVolta.getTime()) + " de " + dataVolta.get(Calendar.YEAR);
    }
}
