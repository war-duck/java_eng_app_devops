package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SettingsScreenController {
    @FXML private Button easyButton;
    @FXML private Button mediumButton;
    @FXML private Button hardButton;

    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("mainScreen");
    }

    public void selectDifficulty(ActionEvent actionEvent) throws IOException{
        Button difficultyButton = (Button) actionEvent.getSource();
        switch (difficultyButton.getText()){
            case "Łatwy":
                difficultyButton.getStyleClass().add("EasyButton");
                mediumButton.getStyleClass().removeAll("MediumButton");
                hardButton.getStyleClass().removeAll("HardButton");
                App.questionDifficulty = Difficulty.EASY;
                break;
            case "Średni":
                difficultyButton.getStyleClass().add("MediumButton");
                easyButton.getStyleClass().removeAll("EasyButton");
                hardButton.getStyleClass().removeAll("HardButton");
                App.questionDifficulty = Difficulty.MEDIUM;
                break;
            case "Trudny":
                difficultyButton.getStyleClass().add("HardButton");
                easyButton.getStyleClass().removeAll("EasyButton");
                mediumButton.getStyleClass().removeAll("MediumButton");
                App.questionDifficulty = Difficulty.HARD;
                break;
        }
    }

    public void setCurrentDifficulty() throws IOException{
        switch(App.questionDifficulty){
            case EASY:
                easyButton.getStyleClass().add("EasyButton");
                mediumButton.getStyleClass().removeAll("MediumButton");
                hardButton.getStyleClass().removeAll("HardButton");
                break;
            case MEDIUM:
                mediumButton.getStyleClass().add("MediumButton");
                easyButton.getStyleClass().removeAll("EasyButton");
                hardButton.getStyleClass().removeAll("HardButton");
                break;
            case HARD:
                hardButton.getStyleClass().add("HardButton");
                easyButton.getStyleClass().removeAll("EasyButton");
                mediumButton.getStyleClass().removeAll("MediumButton");
                break;
        }
    }
}
