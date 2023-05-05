package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RankingScreenController {

    private Stage stage;
    private static Scene mainScreen;
    private FXMLLoader loader;
    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // nowy loader plików FXML
        loader.setLocation(getClass().getResource("mainScreen.fxml")); // wskazujemy plik do załadowania
        mainScreen = new Scene(loader.load(), 640, 360);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(mainScreen);
        stage.show();
    }
}
