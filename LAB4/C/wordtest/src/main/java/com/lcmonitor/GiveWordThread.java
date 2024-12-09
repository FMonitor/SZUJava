package com.lcmonitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.swing.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Font;

public class GiveWordThread implements Runnable {

    private JFrame frame;
    private List<Word> words;
    private int currentIndex = 0;
    private int correctCount = 0;
    private JLabel wordLabel;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JTextField answerField;
    private JLabel statusLabel;
    private Timer timer;

    public GiveWordThread(JFrame frame) {
        this.frame = frame;
        loadWords();
        setupUI();
    }

    private void loadWords() {
        // 使用 ClassLoader 获取 resources 文件夹内的文件
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("words.json");

        if (inputStream == null) {
            System.out.println("文件未找到！");
            return;
        }

        // 读取 JSON 文件，指定 UTF-8 编码
        Gson gson = new Gson();
        try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            Type wordListType = new TypeToken<List<Word>>() {}.getType();
            words = gson.fromJson(reader, wordListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupUI() {
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // 设置默认字体，确保支持中文字符
        Font font = new Font("Microsoft YaHei", Font.PLAIN, 14);

        wordLabel = new JLabel();
        wordLabel.setFont(font);
        frame.add(wordLabel);

        optionA = new JRadioButton();
        optionA.setFont(font);
        optionB = new JRadioButton();
        optionB.setFont(font);
        optionC = new JRadioButton();
        optionC.setFont(font);
        optionD = new JRadioButton();
        optionD.setFont(font);

        ButtonGroup group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        frame.add(optionA);
        frame.add(optionB);
        frame.add(optionC);
        frame.add(optionD);

        answerField = new JTextField(1);
        frame.add(answerField);

        statusLabel = new JLabel();
        statusLabel.setFont(font);
        frame.add(statusLabel);

        frame.setVisible(true);
    }

    @Override
    public void run() {
        if (words == null || words.isEmpty()) {
            System.out.println("没有单词可显示！");
            return;
        }
        
        for (int i = 5; i >= 0; i--) {
            answerField.setText(i+"秒后开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        answerField.setText("开始");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        displayWord(words.get(currentIndex));
        timer = new Timer(3000, e -> {
            if (currentIndex < words.size() && currentIndex < 9) {
                System.out.println("checkAnswer");
                checkAnswer();
                currentIndex++;
                displayWord(words.get(currentIndex));
                
            } else {
                checkAnswer();
                timer.stop();
                JOptionPane.showMessageDialog(frame, "测试结束！你答对了 " + correctCount + " 个题目。");
            }
        });
        timer.start();
    }

    private void displayWord(Word word) {
        wordLabel.setText("Word: " + word.word);
        optionA.setText("A: " + word.selectionA);
        optionB.setText("B: " + word.selectionB);
        optionC.setText("C: " + word.selectionC);
        optionD.setText("D: " + word.selectionD);
        answerField.setText("");
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim().toUpperCase();
        System.out.println("userAnswer: " + userAnswer);
        if (!userAnswer.isEmpty()) {
            Word currentWord = words.get(currentIndex);
            if (userAnswer.equals(String.valueOf(currentWord.correct))) {
                correctCount++;
            }
        }
        statusLabel.setText("已给出题目数量: " + (currentIndex + 1) + "，答对数量: " + correctCount);
    }
}