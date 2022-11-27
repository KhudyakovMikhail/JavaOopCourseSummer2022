package ru.academits.khudyakov.temperature_main;

import ru.academits.khudyakov.temperature.model.*;

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
            JFrame frame = new JFrame("Temperature");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            JButton convertButton = new JButton("Convert");

            JTextField inputTemperatureTextField = new JTextField();

            JLabel outputTemperatureLabel = new JLabel("Result");

            JLabel inputScaleLabel = new JLabel("Input scale");
            JComboBox<TemperatureScale> inputScaleComboBox = new JComboBox<>();
            inputScaleComboBox.addItem(TemperatureScale.Celsius);
            inputScaleComboBox.addItem(TemperatureScale.Kelvin);
            inputScaleComboBox.addItem(TemperatureScale.Fahrenheit);

            JLabel outputScaleLabel = new JLabel("Output scale");
            JComboBox<TemperatureScale> outputScaleComboBox = new JComboBox<>();
            outputScaleComboBox.addItem(TemperatureScale.Celsius);
            outputScaleComboBox.addItem(TemperatureScale.Kelvin);
            outputScaleComboBox.addItem(TemperatureScale.Fahrenheit);

            frame.add(inputScaleLabel, BorderLayout.LINE_START);
            frame.add(inputScaleComboBox, BorderLayout.LINE_START);
            frame.add(convertButton, BorderLayout.CENTER);
            frame.add(outputTemperatureLabel, BorderLayout.PAGE_END);
            frame.add(outputScaleLabel, BorderLayout.LINE_END);
            frame.add(outputScaleComboBox, BorderLayout.LINE_END);
            frame.add(inputTemperatureTextField, BorderLayout.PAGE_START);

            convertButton.addActionListener(e -> {
                TemperatureConverter temperatureConverter;

                if (!isIDouble(inputTemperatureTextField.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "To convert the temperature you have to enter a number");
                }

                if (inputScaleComboBox.getSelectedItem() == TemperatureScale.Celsius) {
                    temperatureConverter = new CelsiusConverter();
                } else if (inputScaleComboBox.getSelectedItem() == TemperatureScale.Kelvin) {
                    temperatureConverter = new KelvinConverter();
                } else {
                    temperatureConverter = new FahrenheitConverter();
                }

                outputTemperatureLabel.setText(String.valueOf(temperatureConverter.convert(Double.parseDouble(inputTemperatureTextField.getText()),
                        (TemperatureScale) outputScaleComboBox.getSelectedItem())));
            });
        });
    }
}
