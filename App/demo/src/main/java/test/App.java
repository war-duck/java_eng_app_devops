package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Scene mainScreen;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("mainScreen.fxml")); // wskazujemy plik do załadowania
        mainScreen = new Scene(loader.load(), 640, 360); // tymczasowo wczytuje od razu scene z pytaniem, mainScreen trzeba stworzyć // do mainscreena dodajemy nowy scene wczytany z pliku
        QuestionHandler.readFromFile(); // Wczytywanie pytań z pliku
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