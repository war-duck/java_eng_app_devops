package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController
{
    private Stage stage;
    private static Scene settingsScreen;
    private static Scene friendsScreen;
    private static Scene rankingScreen;
    private static Scene SingleChoiceTaskScreen;
    private FXMLLoader loader;

    public void startExercise(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("SingleChoiceTask.fxml")); // wskazujemy plik do załadowania
        SingleChoiceTaskScreen = new Scene(loader.load(), 640, 360);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        QuestionInfo questionInfo = QuestionHandler.getRandomQuestion(); // Wybieramy losowo pytanie z dostępnej puli pytań
        QuestionHandler.sendTaskInfoToController(questionInfo, loader); // wysyłamy info o zadaniu do kontrolera danego pliku
        stage.setScene(SingleChoiceTaskScreen);
        stage.show();

    }

    public void openRanking(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("rankingScreen.fxml")); // wskazujemy plik do załadowania
        rankingScreen = new Scene(loader.load(), 640, 360);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(rankingScreen);
        stage.show();
    }

    public void openSettings(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("settingsScreen.fxml")); // wskazujemy plik do załadowania
        settingsScreen = new Scene(loader.load(), 640, 360);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(settingsScreen);
        stage.show();
    }

    public void openFriends(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("friendsScreen.fxml")); // wskazujemy plik do załadowania
        friendsScreen = new Scene(loader.load(), 640, 360);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(friendsScreen);
        stage.show();
    }

}
