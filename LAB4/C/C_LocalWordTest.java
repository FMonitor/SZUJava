// package C;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

class LocalWord {
    String word;
    char correct;
    String selectionA;
    String selectionB;
    String selectionC;
    String selectionD;
    public boolean isCorrect(char selection) {
        return selection == correct;
    }
}

class CreateSelection implements Runnable {
    LocalWord word[]
    
}

public class C_LocalWordTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Local Word Test");
        frame.setBounds(100, 100, 600, 600);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
