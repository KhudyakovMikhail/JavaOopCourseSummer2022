package ru.academits.khudyakov.temperature.view;

import ru.academits.khudyakov.temperature.model.*;

import javax.swing.*;
import java.awt.*;

import static ru.academits.khudyakov.temperature_main.TemperatureMain.isIDouble;

public class TemperatureView {
    public void getView() {
        JFrame frame = new JFrame("Temperature");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);

        JButton convertButton = new JButton("Convert");

        JTextField inputTemperatureTextField = new JTextField();

        JLabel outputTemperatureLabel = new JLabel("Result");

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel centerPanel = new JPanel();

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

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

        frame.add(leftPanel, BorderLayout.LINE_START);
        leftPanel.add(inputScaleLabel);
        leftPanel.add(inputScaleComboBox);

        frame.add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(convertButton);

        frame.add(outputTemperatureLabel, BorderLayout.PAGE_END);

        frame.add(rightPanel, BorderLayout.LINE_END);
        rightPanel.add(outputScaleLabel);
        rightPanel.add(outputScaleComboBox);

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
    }
}
