<<<<<<< HEAD
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.SentenceGenerator;
import model.Statistics;
import model.TimerDisplay;
import model.WindowLoader;

import java.io.IOException;
import java.text.DecimalFormat;


public class GameWindowController {
    public TimerDisplay timerDisplay;
    public Statistics statistics;
    public TextArea sentenceTextField;
    public Button playGame;
    public TextArea typedSentenceTextField;
    public TextField elapsedTimeTextField;
    public TextField donePercentageTextField;
    public TextField wpmTextField;
    public TextField accuracyTextField;
    public TextField mistakeText;
    public Button playAgainButton;
    public AnchorPane gameAnchorPane;


    public GameWindowController() throws IOException {
        statistics = new Statistics();
    }

    public void startGameSessionEvent(ActionEvent actionEvent) throws IOException {
        SentenceGUI();
        timerDisplay = new TimerDisplay();
        playGame.setVisible(false);
        typedSentenceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            elapsedTimeGUI();
            donePercentageGUI(newValue);
            mistakeGUI();
            accuracyGUI();
            wpmGUI(newValue);
            if(isGameEnded()) setGameEndState();
        });
    }

    private void SentenceGUI() throws IOException {
        String sentence=SentenceGenerator.getInstance().generateSentence();
        statistics.setSentence(sentence);
        sentenceTextField.setText(sentence);
    }

    private void elapsedTimeGUI() {
        timerDisplay.getCountDownSeconds();
        elapsedTimeTextField.setText(String.valueOf(timerDisplay.getElapsedTime()));
    }

    private void donePercentageGUI(String typedText) {
        statistics.calculateDonePercentage(typedText);
        DecimalFormat dec = new DecimalFormat("#0.00");
        donePercentageTextField.setText(dec.format(statistics.getDonePercentage()));
    }

    private void wpmGUI(String typedText) {
        statistics.calculateWpm(timerDisplay.getElapsedTime(), typedText);
        wpmTextField.setText(String.valueOf(statistics.getWpm()));
    }

    private void accuracyGUI() {
        statistics.calculateAccuracy();
        DecimalFormat dec = new DecimalFormat("#0.00");
        accuracyTextField.setText(dec.format(statistics.getAccuracy()));
    }

    private void mistakeGUI() { //if user makes a typing mistake pop-up text appears

        if (statistics.isWritingMistake()) mistakeText.setVisible(true);
        else {
            mistakeText.setVisible(false);
        }
    }

    private boolean isGameEnded() {
        if (statistics.getDonePercentage() == 100.d) return true;
        return false;
    }

    private void setGameEndState() {
        typedSentenceTextField.setDisable(true);
        playAgainButton.setVisible(true);

    }


    public void PlayAgainSessionEvent(ActionEvent actionEvent) throws IOException {

        new WindowLoader().loadGameWindow(gameAnchorPane);
    }
}
=======
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Statistics;
import model.TimerDisplay;
import model.WindowLoader;

import java.io.IOException;
import java.text.DecimalFormat;


public class GameWindowController {
    public TimerDisplay timerDisplay;
    public Statistics statistics;
    public TextArea sentenceTextField;
    public Button playGame;
    public TextArea typedSentenceTextField;
    public TextField elapsedTimeTextField;
    public TextField donePercentageTextField;
    public TextField wpmTextField;
    public TextField accuracyTextField;
    public TextField mistakeText;
    public Button playAgainButton;
    public AnchorPane gameAnchorPane;


    public GameWindowController() throws IOException {
        statistics = new Statistics();
    }

    public void startGameSessionEvent(ActionEvent actionEvent) {
        SentenceGUI();
        timerDisplay = new TimerDisplay();
        playGame.setVisible(false);
        typedSentenceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            elapsedTimeGUI();
            donePercentageGUI(newValue);
            mistakeGUI();
            accuracyGUI();
            wpmGUI(newValue);
            if(isGameEnded()) setGameEndState();
        });
    }

    private void SentenceGUI() {
        sentenceTextField.setText(statistics.getSentence());
    }

    private void elapsedTimeGUI() {
        timerDisplay.getCountDownSeconds();
        elapsedTimeTextField.setText(String.valueOf(timerDisplay.getElapsedTime()));
    }

    private void donePercentageGUI(String typedText) {
        statistics.calculateDonePercentage(typedText);
        DecimalFormat dec = new DecimalFormat("#0.00");
        donePercentageTextField.setText(dec.format(statistics.getDonePercentage()));
    }

    private void wpmGUI(String typedText) {
        statistics.calculateWpm(timerDisplay.getElapsedTime(), typedText);
        wpmTextField.setText(String.valueOf(statistics.getWpm()));
    }

    private void accuracyGUI() {
        statistics.calculateAccuracy();
        DecimalFormat dec = new DecimalFormat("#0.00");
        accuracyTextField.setText(dec.format(statistics.getAccuracy()));
    }

    private void mistakeGUI() { //if user makes a typing mistake pop-up text appears

        if (statistics.isWritingMistake()) mistakeText.setVisible(true);
        else {
            mistakeText.setVisible(false);
        }
    }

    private boolean isGameEnded() {
        if (statistics.getDonePercentage() == 100.d) return true;
        return false;
    }

    private void setGameEndState() {
        typedSentenceTextField.setDisable(true);
        playAgainButton.setVisible(true);

    }


    public void PlayAgainSessionEvent(ActionEvent actionEvent) throws IOException {
        new WindowLoader().loadGameWindow(gameAnchorPane);
    }
}
>>>>>>> de77b63f8efce10dd1e2a6689b8f03c8e3e5a713
