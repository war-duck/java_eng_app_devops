package main;

import javafx.event.ActionEvent;

import java.io.IOException;

public class FriendsScreenController {
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("mainScreen");
    }
}