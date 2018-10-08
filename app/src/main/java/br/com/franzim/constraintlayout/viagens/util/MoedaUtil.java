package br.com.franzim.constraintlayout.viagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String MOEDA_FORMATO_PADRAO = "R$";
    public static final String MOEDA_FORMATO_DESEJADO = "R$ ";

    public static String formataMoedaBR(BigDecimal valor) {
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBR.format(valor).replace(MOEDA_FORMATO_PADRAO, MOEDA_FORMATO_DESEJADO);
    }

}
