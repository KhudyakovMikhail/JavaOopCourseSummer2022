package ru.academits.khudyakov.temperature_main;

import ru.academits.khudyakov.temperature.model.*;
import ru.academits.khudyakov.temperature.view.TemperatureView;

import javax.swing.*;
import java.awt.*;

public class TemperatureMain {
    public static boolean isIDouble(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureView view = new TemperatureView();
            view.getView();
        });
    }
}
