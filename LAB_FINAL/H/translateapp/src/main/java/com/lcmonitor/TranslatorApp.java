package com.lcmonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TranslatorApp {
    private static JFrame frame = new JFrame();
    private static JLabel labelInput = new JLabel();
    private static JTextField textFieldInput = new JTextField();
    private static JLabel labelOutput = new JLabel();
    private static JTextField textFieldOutput = new JTextField();
    private static JButton buttonTranslate = new JButton();

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("你好", "Hello");
        dictionary.put("世界", "World");
        dictionary.put("Hello", "你好");
        dictionary.put("World", "世界");
    }

    public static void main(String[] args) {

        Font font = new Font("Microsoft YaHei", Font.PLAIN, 20);
        frame.setFont(font);
        labelInput.setFont(font);
        textFieldInput.setFont(font);
        labelOutput.setFont(font);
        textFieldOutput.setFont(font);
        buttonTranslate.setFont(font);

        labelInput.setText("输入:");
        labelOutput.setText("翻译:");
        textFieldOutput.setEditable(false);
        buttonTranslate.setText("翻译");

        frame.setTitle("翻译器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(labelInput);
        frame.add(textFieldInput);
        frame.add(labelOutput);
        frame.add(textFieldOutput);
        frame.add(buttonTranslate);

        buttonTranslate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textFieldInput.getText();
                String translation = dictionary.get(input);
                if (translation != null) {
                    textFieldOutput.setText(translation);
                } else {
                    textFieldOutput.setText("未找到翻译");
                }
            }
        });

        frame.setVisible(true);
    }
}