package com.lcmonitor;

public class Word {
    String word;
    String correct;
    String selectionA;
    String selectionB;
    String selectionC;
    String selectionD;
    public boolean isCorrect(String selection) {
        return selection == correct;
    }
}
