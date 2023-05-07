package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class App extends Application {
    private static Scene mainScreen;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("mainScreen.fxml")); // wskazujemy plik do załadowania
        mainScreen = new Scene(loader.load(), 640, 360); // do mainscreena dodajemy nowy scene wczytany z pliku
        try {
            QuestionHandler.readFromFile(getClass().getResource("SingleChoiceQuestions.txt").toURI()); // Wczytywanie pytań z pliku
        }
        catch (URISyntaxException exception) {
            exception.printStackTrace();
        }
        stage.getIcons().add(new Image(getClass().getResource("app_icon.png").toExternalForm())); //Ustawia ikonę aplikacji
        stage.setTitle("Aplikacja do nauki języka angieskiego"); //Ustawia tytuł aplikacji
        stage.setScene(mainScreen);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}