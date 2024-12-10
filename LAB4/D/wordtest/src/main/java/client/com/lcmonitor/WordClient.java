package client.com.lcmonitor;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class WordClient {
    private JFrame frame;
    private JLabel wordLabel;
    private Timer timer;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private ButtonGroup group;
    private JLabel statusLabel;
    private JTextField answerField;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new WordClient().createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public WordClient() throws IOException {
        Socket socket = new Socket("localhost", 12345);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
    }

    private void createAndShowGUI() {
        frame = new JFrame("Word Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setPreferredSize(new Dimension(400, 300));

        Font font = new Font("Microsoft YaHei", Font.PLAIN, 14);

        wordLabel = new JLabel();
        wordLabel.setFont(font);
        frame.add(wordLabel);

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        frame.add(optionA);
        frame.add(optionB);
        frame.add(optionC);
        frame.add(optionD);

        answerField = new JTextField();
        answerField.addActionListener(e -> submitAnswer());
        frame.add(answerField);

        statusLabel = new JLabel();
        frame.add(statusLabel);

        frame.pack();
        frame.setVisible(true);

        new Thread(new WordReceiver()).start();
    }

    private void submitAnswer() {
        String answer = answerField.getText().trim().toUpperCase();
        out.println(answer);
        answerField.setText("");
    }

    private class WordReceiver implements Runnable {
        @Override
        public void run() {

            for (int i = 5; i >= 0; i--) {
                answerField.setText(i + "秒后开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            answerField.setText("开始");

            timer = new Timer(3000, e -> {
                try {
                    System.out.println("Submitted answer");
                    submitAnswer();
                    String word = in.readLine();
                    System.out.println("Received word: " + word);
                    if (word.equals("END")) {
                        String result = in.readLine();
                        JOptionPane.showMessageDialog(frame, "测试结束！" + result);
                        System.exit(0);
                    }
                    
                    String selectionA = in.readLine();
                    String selectionB = in.readLine();
                    String selectionC = in.readLine();
                    String selectionD = in.readLine();
                    String status = in.readLine();

                    SwingUtilities.invokeLater(() -> {
                        wordLabel.setText("Word: " + word);
                        optionA.setText("A: " + selectionA);
                        optionB.setText("B: " + selectionB);
                        optionC.setText("C: " + selectionC);
                        optionD.setText("D: " + selectionD);
                        statusLabel.setText(status);
                        group.clearSelection();
                    });
                    
                    
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            });
            timer.start();
            submitAnswer();
        }
    }
}