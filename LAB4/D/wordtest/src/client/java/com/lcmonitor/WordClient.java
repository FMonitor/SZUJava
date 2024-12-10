package client.java.lcmonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class WordClient {
    private JFrame frame;
    private JLabel wordLabel;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private ButtonGroup group;
    private JLabel statusLabel;
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
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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

        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(new SubmitButtonListener());
        frame.add(submitButton);

        statusLabel = new JLabel();
        frame.add(statusLabel);

        frame.pack();
        frame.setVisible(true);

        new Thread(new WordReceiver()).start();
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedOption = null;
            if (optionA.isSelected()) {
                selectedOption = "A";
            } else if (optionB.isSelected()) {
                selectedOption = "B";
            } else if (optionC.isSelected()) {
                selectedOption = "C";
            } else if (optionD.isSelected()) {
                selectedOption = "D";
            }

            if (selectedOption != null) {
                out.println(selectedOption);
            }
        }
    }

    private class WordReceiver implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    String word = in.readLine();
                    if (word.equals("END")) {
                        JOptionPane.showMessageDialog(frame, "测试结束！");
                        break;
                    }

                    String selectionA = in.readLine();
                    String selectionB = in.readLine();
                    String selectionC = in.readLine();
                    String selectionD = in.readLine();
                    String status = in.readLine();

                    wordLabel.setText("Word: " + word);
                    optionA.setText("A: " + selectionA);
                    optionB.setText("B: " + selectionB);
                    optionC.setText("C: " + selectionC);
                    optionD.setText("D: " + selectionD);
                    statusLabel.setText(status);

                    group.clearSelection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}