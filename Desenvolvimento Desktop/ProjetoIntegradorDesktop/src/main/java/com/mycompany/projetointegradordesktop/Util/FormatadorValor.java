package com.mycompany.projetointegradordesktop.Util;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class FormatadorValor {
    
    private static final NumberFormat FORMATADOR = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    private static final NumberFormatter nf = new NumberFormatter(FORMATADOR);
    
    
    public static void formatarCampo(JFormattedTextField campo) {
        FORMATADOR.setMaximumFractionDigits(2);
        FORMATADOR.setMinimumFractionDigits(2);
        nf.setAllowsInvalid(false);
        campo.setFormatterFactory(new DefaultFormatterFactory(nf));
    }
    
    public static String formatarValor(double valor) {
        FORMATADOR.setMaximumFractionDigits(2);
        FORMATADOR.setMinimumFractionDigits(2);
        return FORMATADOR.format(valor);
    }
}
