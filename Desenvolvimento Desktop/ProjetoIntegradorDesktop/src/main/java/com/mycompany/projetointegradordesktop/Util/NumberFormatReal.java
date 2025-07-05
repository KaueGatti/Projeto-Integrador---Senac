package com.mycompany.projetointegradordesktop.Util;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class NumberFormatReal {
    
    private static final NumberFormat format = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    private static final NumberFormatter nf = new NumberFormatter(format);
    
    
    public static void formatReal(JFormattedTextField campo) {
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        nf.setAllowsInvalid(false);
        campo.setFormatterFactory(new DefaultFormatterFactory(nf));
        campo.setFormatterFactory(new DefaultFormatterFactory(nf));
    }

    public static NumberFormat getFormat() {
        return format;
    }

    public static NumberFormatter getNf() {
        return nf;
    }
    
}
