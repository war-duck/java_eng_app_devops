package test;

import java.io.IOException;

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
    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
    public void setQuestionContent(String questionContent)
    {
        this.questionContent.setText(questionContent);
    }
    public Label getQuestionContent()
    {
        return questionContent;
    }
    private void displayTaskResult(String userChosenAnswer) // zmienia dedykowaną Label taskResult
    {
        if (userChosenAnswer.equals(this.correctAnswer)) // jezeli użytkownik odpowiedział poprawnie
        {
            taskResult.setText("Odpowiedź poprawna!"); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
        }
        else
        {
            taskResult.setText("Odpowiedź błędna! Prawidłowa odpowiedź to " + correctAnswer); // tymczasowy, brzydki sposób. Przydałoby się zrobić coś lepszego, np osobną scenę
            taskResult.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        }
    }
    @FXML public void handleButtonPressed(ActionEvent userChosenAnswer)
    {
        taskResult.setVisible(false);
        Object source = userChosenAnswer.getSource();
        if (source instanceof Button) // jeżeli funkcja została wywołana przez przycisk (powinna być)
            displayTaskResult(((Button)source).getText()); // bierze tekst na przycisku klikniętym przez użytkownika
        taskResult.setVisible(true); // ujawnia Label z wiadomością
    }
}
