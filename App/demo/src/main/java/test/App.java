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
        QuestionInfo questionInfo = new QuestionInfo();
        String[] optionContent = {"dsa", "das", "test", "esc"};
        questionInfo.setAll("test", "Który ciąg znaków?", "hint hint git gud", optionContent);
        sendTaskInfoToController(questionInfo, loader); // wysyłamy info o zadaniu do kontrolera danego pliku
                                                                                                                                // correctAnswer i questionContent będą wczytywane z pliku
        stage.setScene(mainScreen);

        stage.show();
    }

    private void sendTaskInfoToController(QuestionInfo questionInfo, FXMLLoader loader) // wysyła dane o zadaniu do kontrolera
    {
        SingleChoiceTaskController controller = loader.getController(); // znajdujemy obecną instancję kontrolera
        controller.setCorrectAnswer(questionInfo.correctAnswer);
        controller.setQuestionContent(questionInfo.questionContent);
        controller.setHintContent(questionInfo.hintContent);
        controller.setOptionButtons(questionInfo.answerOptions);
    }
    public static void main(String[] args)
    {
        launch();
    }

}