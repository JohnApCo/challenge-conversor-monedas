package com.conversor;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ConversorTemperatura extends Conversor{

    public Map<String, Runnable> createActionMap(double valor) {
        Map<String, Runnable> actionMap = new HashMap<>();
        actionMap.put("Grados Celcius a Grados Farenheit", () -> convertFunction(valor,"Celcius","Farenheit", valueIn -> valueIn * 1.8 + 32));
        actionMap.put("Grados Celcius a Kelvin", () -> convertFunction(valor,"Celcius","Farenheit", valueIn -> valueIn + 273.15));
        actionMap.put("Grados Farenheit a Grados Celcius", () -> convertFunction(valor,"Celcius","Farenheit", valueIn -> (valueIn - 32) / 1.8));
        actionMap.put("Kelvin a Grados Celcius", () -> convertFunction(valor,"Celcius","Farenheit", valueIn ->  valueIn - 273.15));
        actionMap.put("Kelvin a Grados Farenheit", () -> convertFunction(valor,"Celcius","Farenheit", valueIn -> 1.8*(valueIn - 273.15) + 32));
        return actionMap;
    }

    public String selectConversionOption(Map<String, Runnable> actionMap) {
        String[] options = actionMap.keySet().toArray(new String[0]);
        return (String) JOptionPane.showInputDialog(null,
                "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    private void convertFunction(double valor,String tipoOrigen, String tipoDestino, Function<Double,Double> Function) {
        double valorConvertido = Function.apply(valor);
        valorConvertido = (double) Math.round(valorConvertido * 100d) / 100;
        JOptionPane.showMessageDialog(null, String.format("%.2f %s son %.2f %s", valor, tipoOrigen, valorConvertido, tipoDestino));
    }
}
