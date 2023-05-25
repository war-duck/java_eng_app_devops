package main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class App extends Application {
    public static Stage stage;
    public static final int vSize = 800;
    public static final int hSize = 450;
    @Override
    public void start(Stage receivedStage) throws IOException {
        stage = receivedStage;
        try {
            QuestionHandler.readFromFile(getClass().getResource("SingleChoiceQuestions.txt").toURI()); // Wczytywanie pytań z pliku
        }
        catch (URISyntaxException exception) {
            exception.printStackTrace();
        }
        stage.setOnCloseRequest(event -> {
            try {
                QuestionHandler.saveFailedQuestionsToFile();
            }
            catch (IOException ioe) {
                System.err.println("Nie udało się zapisać źle wykonanych zadań do FailedQuestions.txt. Msg:\n\t" + ioe.getLocalizedMessage());
            }
        });
        stage.getIcons().add(new Image(getClass().getResource("app_icon.png").toExternalForm())); //Ustawia ikonę aplikacji
        stage.setTitle("Aplikacja do nauki języka angieskiego"); //Ustawia tytuł aplikacji
        SceneHandler.showScene("mainScreen");
    }

    public static void main(String[] args) {
        launch();
    }
}
