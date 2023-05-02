package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene mainScreen;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("SingleChoiceTask.fxml")); // wskazujemy plik do załadowania
        mainScreen = new Scene(loader.load(), 640, 360); // tymczasowo wczytuje od razu scene z pytaniem, mainScreen trzeba stworzyć // do mainscreena dodajemy nowy scene wczytany z pliku
        sendTaskInfoToController("A", "A, B, C czy D?", "hint hint git gud", loader); // wysyłamy info o zadaniu do kontrolera danego pliku
                                                                                                                                // correctAnswer i questionContent będą wczytywane z pliku
        stage.setScene(mainScreen);
        stage.show();
    }

    private void sendTaskInfoToController(String correctAnswer, String questionContent, String hintContent, FXMLLoader loader) // wysyła dane o zadaniu do kontrolera
    {
        SingleChoiceTaskController controller = loader.getController(); // znajdujemy obecną instancję kontrolera
        controller.setCorrectAnswer(correctAnswer);
        controller.setQuestionContent(questionContent);
        controller.setHintContent(hintContent);
    }
    public static void main(String[] args)
    {
        launch();
    }

}