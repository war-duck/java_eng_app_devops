package main;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainScreenController
{
    public void startExercise() throws IOException {
        try {
            SceneInfo sceneInfo = SceneHandler.getSceneInfo("singleChoiceTask");
            QuestionInfo questionInfo = QuestionHandler.getRandomQuestion(); // Wybieramy losowo pytanie z dostępnej puli pytań
            QuestionHandler.sendTaskInfoToController(questionInfo, sceneInfo.loader); // wysyłamy info o zadaniu do kontrolera danego pliku
            App.stage.setScene(sceneInfo.scene);
            App.stage.show();
        }
        catch (Exception e) {
            throw new IOException("Nie można wczytać singleChoiceTask.\nMsg: " + e.getLocalizedMessage());
        }
    }

    public void openRanking() throws IOException {
        SceneHandler.showScene("rankingScreen");
    }

    public void openSettings(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("settingsScreen");
    }

    public void openFriends(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("friendsScreen");
    }

}
