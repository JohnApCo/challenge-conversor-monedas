package com.conversor;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConversorMoneda extends Conversor{
    public Map<String, Runnable> createActionMap(double valor) {
        Map<String, Runnable> actionMap = new HashMap<>();
        //De Pesos
        actionMap.put("De Pesos a Dólar", () -> convertFunction(valor,"Pesos","Dolares",3739.00));
        actionMap.put("De Pesos a Euros", () -> convertFunction(valor,"Pesos","Euros",4050.48));
        actionMap.put("De Pesos a Libras", () -> convertFunction(valor,"Pesos","Libras",4890.52));
        actionMap.put("De Pesos a Yen", () -> convertFunction(valor,"Pesos","Yen",29.68));
        actionMap.put("De Pesos a Wones", () -> convertFunction(valor,"Pesos","Won",3.04));
        //A Pesos
        actionMap.put("De Dolares a Pesos", () -> convertFunction(valor,"Dolares","Pesos",1/3739.00));
        actionMap.put("De Euros a Pesos", () -> convertFunction(valor,"Euros","Pesos",1/4050.48));
        actionMap.put("De Libras a Pesos", () -> convertFunction(valor,"Libras","Pesos",1/4890.52));
        actionMap.put("De Yen a Pesos", () -> convertFunction(valor,"Yen","Pesos",1/29.68));
        actionMap.put("De Won a Pesos", () -> convertFunction(valor,"Won","Pesos",1/3.04));

        return actionMap;
    }

    public String selectConversionOption(Map<String, Runnable> actionMap) {
        String[] options = actionMap.keySet().toArray(new String[0]);
        return (String) JOptionPane.showInputDialog(null,
                "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    private static void convertFunction(double valor, String tipoOrigen, String tipoDestino, double tasaDeConversion) {
        double valorConvertido = valor / tasaDeConversion;
        valorConvertido = (double) Math.round(valorConvertido * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Tienes $" + valorConvertido + " " + tipoDestino);
    }
}
