package test;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SettingsScreenController {
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("mainScreen");
    }
}
