package model;

import java.io.IOException;

public class Statistics extends SentenceGenerator {

    private int wpm;
    private int writingMistakeCount;
    private double accuracy;
    private double donePercentage;
    private boolean writingMistake;

    public Statistics() throws IOException {
        wpm = 0;
        accuracy = 0.0f;
        donePercentage = 0.0f;
        writingMistake = false;
        writingMistakeCount=0;
    }

    private int countSentenceWords(String typedString) {
        if (typedString == null || typedString.isEmpty()) {
            return 0;
        }
        String[] words = typedString.split("\\s+");
        return words.length;
    }

    private int getSentenceCharLength() {
        return sentence.length();
    }

    public void calculateWpm(int timeElapsed, String typedString) {
        double minutesElapsed = (float) timeElapsed / 60.f;
        double wpmTemp = countSentenceWords(typedString) / minutesElapsed;
        wpm = (int) Math.floor(wpmTemp);
    }

    public void calculateDonePercentage(String typedString) {
        int comparablechars = 0;
        writingMistake = false;
        char[] sentenceChars=sentence.toCharArray();
        char[] typedTextChars=typedString.toCharArray();
        for (int i = 0; i < typedTextChars.length; i++) { //comparing sentence and typed string chars
            if (typedTextChars[i]==sentenceChars[i]) {
                comparablechars++;
            } else {
                writingMistake = true;
            }
        }
        donePercentage = (double)comparablechars / getSentenceCharLength();
        donePercentage*=100.00;
    }

    public void calculateAccuracy() {
        if(writingMistake) writingMistakeCount++;
        accuracy=(double)getSentenceCharLength()-(double)writingMistakeCount;
        accuracy=(accuracy/(double)getSentenceCharLength())*100.d;
    }

    public int getWpm() {
        return wpm;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getDonePercentage() {
        return donePercentage;
    }

    public boolean isWritingMistake() {
        return writingMistake;
    }
}
