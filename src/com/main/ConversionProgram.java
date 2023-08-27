package com.main;

import com.conversor.Conversor;
import com.conversor.ConversorMoneda;
import com.conversor.ConversorTemperatura;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConversionProgram {
    public static void main(String[] args) {
        Map<String, Runnable> actionMap = createActionMap();
        while(true) {
            String selectedOption = selectConversionOption(actionMap);
            if (selectedOption != null && actionMap.containsKey(selectedOption)) {
                actionMap.get(selectedOption).run();
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                System.exit(0);
            }
        }
    }
    private static Map<String, Runnable> createActionMap() {
        Map<String, Runnable> actionMap = new HashMap<>();
        actionMap.put("Conversor de Moneda", ConversionProgram::convertCurrency);
        actionMap.put("Conversor de Temperatura", ConversionProgram::convertTemperature);
        // Agregar más acciones si es necesario
        return actionMap;
    }
    private static String selectConversionOption(Map<String, Runnable> actionMap) {
        String[] options = actionMap.keySet().toArray(new String[0]);
        return (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión:", "Menú", JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
    }
    public static boolean isValidNumber(String input) {
        try {
            double x = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static void convertCurrency() {
        String input = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir: ");
        if (!isValidNumber(input)) {
            JOptionPane.showMessageDialog(null, "Valor inválido");
            return;
        }

        double amount = Double.parseDouble(input);
        // Lógica de conversión de moneda
        Conversor monedas = new ConversorMoneda();
        monedas.convert(amount);

        int res = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
        if (res == JOptionPane.OK_OPTION) {
            System.out.println("Selecciona opción Afirmativa");
        } else {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            System.exit(0);
        }
    }

    private static void convertTemperature() {
        String input = JOptionPane.showInputDialog("Ingresa el valor de la temperatura que deseas convertir ");
        if (!isValidNumber(input)) {
            JOptionPane.showMessageDialog(null, "Valor inválido");
            return;
        }

        double temperature = Double.parseDouble(input);
        // Lógica de conversión de temperatura.
        Conversor temperatura = new ConversorTemperatura();
        temperatura.convert(temperature);

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
        if (respuesta == JOptionPane.OK_OPTION) {
            System.out.println("Selecciona opción Afirmativa");
        } else {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            System.exit(0);
        }
    }
}