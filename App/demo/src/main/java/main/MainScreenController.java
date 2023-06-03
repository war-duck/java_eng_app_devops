package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainScreenController {
    @FXML
    Label infoLabel;
    @FXML Label testInfoLabel;
    public void initialize() {
        if (QuestionHandler.getFailedQuestionSet().isEmpty())
            testInfoLabel.setText("Brak zadań do powtórzenia");
        else
            testInfoLabel.setText("Zadań do powtórzenia: " + QuestionHandler.getFailedQuestionSet().size());
    }
    public void startExercise() throws IOException {
        if (QuestionHandler.getQuestionList().isEmpty()) {
            showInfoLabel("Nie ma dostępnych pytań", true);
            return;
        }
        showInfoLabel(null, false);
        SceneInfo sceneInfo = SceneHandler.getSceneInfo("singleChoiceTask");
        QuestionInfo questionInfo = QuestionHandler.getRandomQuestion(); // Wybieramy losowo pytanie z dostępnej puli pytań
        QuestionHandler.sendTaskInfoToController(questionInfo, sceneInfo.loader); // wysyłamy info o zadaniu do kontrolera danego pliku
        App.stage.setScene(sceneInfo.scene);
        App.stage.show();
    }

    public void startExam() throws IOException {
        if (QuestionHandler.getFailedQuestionSet().isEmpty()) {
            showInfoLabel("Nie ma zadań do powtórzenia", true);
            return;
        }
        showInfoLabel(null, false);
        ExamHandler.startExam();
    }

    public void openRanking() throws IOException {
        SceneHandler.showScene("rankingScreen");
    }

    public void openSettings() throws IOException {
        SceneHandler.showScene("settingsScreen");
    }

    public void openFriends() throws IOException {
        SceneHandler.showScene("friendsScreen");
    }

    private void showInfoLabel(String message, Boolean isVisible) {
        infoLabel.setText(message);
        infoLabel.setVisible(isVisible);
    }
}
