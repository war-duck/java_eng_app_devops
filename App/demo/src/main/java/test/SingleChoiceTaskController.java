package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class SingleChoiceTaskController
{
    private String correctAnswer;   // otrzymana z App w sendCorrectAnswerToController
    @FXML private Label questionContent;
    @FXML private Label taskResult;       // info o poprawności odpowiedzi użytkownika
    @FXML private Button hintButton;
    @FXML private Label hintLabel;
    @FXML private Button buttonA, buttonB, buttonC, buttonD;
    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
    public void setQuestionContent(String questionContent)
    {
        this.questionContent.setText(questionContent);
    }
    public void setHintContent(String hintContent)
    {
        this.hintLabel.setText(hintContent);
    }
    public Label getQuestionContent()
    {
        return questionContent;
    }
    public void setOptionButtons(String[] buttonContent)
    {
        buttonA.setText(buttonContent[0]);
        buttonB.setText(buttonContent[1]);
        buttonC.setText(buttonContent[2]);
        buttonD.setText(buttonContent[3]);
    }
    private void displayTaskResult(String userChosenAnswer) // zmienia dedykowaną Label taskResult
    {
        if (userChosenAnswer.equals(this.correctAnswer)) // jezeli użytkownik odpowiedział poprawnie
        {
            taskResult.setText("Odpowiedź poprawna!"); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, new CornerRadii(5), Insets.EMPTY)));
        }
        else
        {
            taskResult.setText("Odpowiedź błędna! Prawidłowa odpowiedź to '" + correctAnswer + "'"); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        }
    }
    @FXML public void handleAnswerButtonPressed(ActionEvent userChosenAnswer)
    {
        taskResult.setVisible(false);
        Object source = userChosenAnswer.getSource();
        if (source instanceof Button) // jeżeli funkcja została wywołana przez przycisk (powinna być)
            displayTaskResult(((Button)source).getText()); // bierze tekst na przycisku klikniętym przez użytkownika
        taskResult.setVisible(true); // ujawnia Label z wiadomością
    }
    @FXML public void handleHintButtonPressed()
    {
        hintButton.setVisible(false);
        hintButton.setManaged(false); // tak żeby treść label pojawiła się zamiast button, nie pod
        hintLabel.setVisible(true);
    }
    @FXML public void goBack()
    {
        SceneHandler.showScene("mainScreen");
    }
}
