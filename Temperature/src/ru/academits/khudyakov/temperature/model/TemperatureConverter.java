package ru.academits.khudyakov.temperature.model;

public interface TemperatureConverter {
    double convert(double inputTemperature, TemperatureScale outputTemperatureScale);
}
