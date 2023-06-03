package main;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class SceneHandler {
    private SceneHandler(){}
    public static SceneInfo getSceneInfo (String sceneName) throws IOException {
        try {
            SceneInfo returnValue = new SceneInfo(sceneName, new FXMLLoader(), null);
            returnValue.loader.setLocation(SceneHandler.class.getResource(sceneName + ".fxml"));
            if (returnValue.loader.getLocation() == null)
                throw new IOException("Nieudana próba wczytania " + sceneName + ".fxml", null);
            returnValue.scene = new Scene(returnValue.loader.load(), App.vSize, App.hSize);
            return returnValue;
        }
        catch (IOException ioe) {
            System.err.println("Błąd ładowania pliku '" + sceneName + ".fxml' Msg: " + ioe.getLocalizedMessage());
            throw ioe;
        }
    }

    public static SceneInfo showScene (String sceneName) throws IOException {
        SceneInfo sceneInfo = getSceneInfo(sceneName);
        App.stage.setScene(sceneInfo.scene);
        App.stage.show();
        return sceneInfo;
    }
}
