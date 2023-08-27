package com.conversor;

import javax.swing.*;
import java.util.Map;

public abstract class Conversor {
    public void convert(double valor) {
        Map<String, Runnable> actionMap = createActionMap(valor);
        String selectedOption = selectConversionOption(actionMap);
        if (selectedOption != null && actionMap.containsKey(selectedOption)) {
            actionMap.get(selectedOption).run();
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            System.exit(0);
        }
    }

    public abstract Map<String, Runnable> createActionMap(double valor);
    public abstract String selectConversionOption(Map<String, Runnable> actionMap);
}
