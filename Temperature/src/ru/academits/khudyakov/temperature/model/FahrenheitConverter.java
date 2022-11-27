package ru.academits.khudyakov.temperature.model;

public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public double convert(double inputTemperature, TemperatureScale outputTemperatureScale) {
        if (outputTemperatureScale == TemperatureScale.Celsius){
            return (inputTemperature - 32) / 1.8;
        }

        if (outputTemperatureScale == TemperatureScale.Kelvin){
            return (inputTemperature - 32) / 1.8 + 273.15;
        }

        return inputTemperature;
    }
}
