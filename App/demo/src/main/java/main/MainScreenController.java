package main;

import java.io.IOException;

public class MainScreenController
{
    public void startExercise() throws IOException {
        SceneInfo sceneInfo = SceneHandler.getSceneInfo("singleChoiceTask");
        QuestionInfo questionInfo = QuestionHandler.getRandomQuestion(); // Wybieramy losowo pytanie z dostępnej puli pytań
        QuestionHandler.sendTaskInfoToController(questionInfo, sceneInfo.loader); // wysyłamy info o zadaniu do kontrolera danego pliku
        App.stage.setScene(sceneInfo.scene);
        App.stage.show();
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

}
