package com.lcmonitor;

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Local Word Test");
        frame.setBounds(100, 100, 400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setVisible(true);
        
        GiveWordThread sendWordThread = new GiveWordThread(frame);
        sendWordThread.run();

    }
}