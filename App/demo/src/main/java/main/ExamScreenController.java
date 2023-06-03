package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ExamScreenController implements TaskControllerInterface {
    @FXML private Label wordList;
    @FXML private Label wordNumber;
    private String correctAnswer;   // otrzymana z App w sendCorrectAnswerToController
    @FXML
    private Label questionContent;
    @FXML
    private Label taskResult;       // info o poprawności odpowiedzi użytkownika
    @FXML
    private Button hintButton;
    @FXML
    private Label hintLabel;
    @FXML
    private Button buttonA, buttonB, buttonC, buttonD;

    public void setQuestionInfo(QuestionInfo questionInfo) {/*wymagane przez interfejs, tutaj nie potrzebne bo ExamHandler przechowuje info*/}

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent.setWrapText(true);
        this.questionContent.setText(questionContent);
    }

    public void setHintContent(String hintContent) {
        this.hintLabel.setText(hintContent);
    }

    public void setOptionButtons(String[] buttonContent) {
        buttonA.setText(buttonContent[0]);
        buttonB.setText(buttonContent[1]);
        buttonC.setText(buttonContent[2]);
        buttonD.setText(buttonContent[3]);
    }

    private void displayTaskResult(String userChosenAnswer) { // zmienia dedykowaną Label taskResult
        if (userChosenAnswer.equals(this.correctAnswer)) // jezeli użytkownik odpowiedział poprawnie
        {
            taskResult.setText("Odpowiedź poprawna!"); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, new CornerRadii(5), Insets.EMPTY)));
        } else {
            taskResult.setText("Odpowiedź błędna! Prawidłowa odpowiedź to '" + correctAnswer + "'"); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        }
    }

    private void handleAnswerChosen(String answer) throws IOException {
        displayTaskResult(answer); // bierze tekst na przycisku klikniętym przez użytkownika
        if (answer.equals(this.correctAnswer)) {
            ExamHandler.addCurrentQuestionToSolved();
            ExamHandler.popCurrentQuestion();
            ExamHandler.nextQuestion();
        }
    }

    @FXML
    public void handleAnswerButtonPressed(ActionEvent userChosenAnswer) throws IOException {
        taskResult.setVisible(false);
        Object source = userChosenAnswer.getSource();
        if (source instanceof Button) { // jeżeli funkcja została wywołana przez przycisk (powinna być)
            handleAnswerChosen(((Button) source).getText());
        }
        taskResult.setVisible(true); // ujawnia Label z wiadomością
    }

    @FXML
    public void handleHintButtonPressed() {
        hintButton.setVisible(false);
        hintButton.setManaged(false); // tak żeby treść label pojawiła się zamiast button, nie pod
        hintLabel.setVisible(true);
    }

    @FXML
    public void goBack() throws IOException {
        ExamHandler.endExam(false);
    }
    @FXML
    public void handleSkipButtonPressed() throws IOException {
        ExamHandler.nextQuestion();
    }
    public void setWordListLabelText(String message) {
        wordList.setText(message);
    }
    public void setWordNumberLabelText(String message) {
        wordNumber.setText(message);
    }
}
