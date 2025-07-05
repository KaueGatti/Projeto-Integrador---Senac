package com.mycompany.projetointegradordesktop.Util;

import javax.swing.table.DefaultTableCellRenderer;

public class RealRendererTable extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object value) {
        if (value instanceof Number) {
            setText(NumberFormatReal.getFormat().format(value));
        }
    }
}
