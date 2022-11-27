package ru.academits.khudyakov.temperature.model;

public class KelvinConverter implements TemperatureConverter {
    @Override
    public double convert(double inputTemperature, TemperatureScale outputTemperatureScale) {
        if (outputTemperatureScale == TemperatureScale.Celsius){
            return inputTemperature - 273.15;
        }

        if (outputTemperatureScale == TemperatureScale.Fahrenheit){
            return (inputTemperature - 273.15) * 1.8 + 32;
        }

        return inputTemperature;
    }
}
