package test;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.lang.reflect.Field;

public class SceneHandler {
    public static SceneInfo mainScreenScene       = null;
    public static SceneInfo friendsScreenScene    = null;
    public static SceneInfo rankingScreenScene    = null;
    public static SceneInfo settingsScreenScene   = null;
    public static SceneInfo singleChoiceTaskScene = null;
    public static FXMLLoader currentLoader        = null;
    
    public static SceneInfo getSceneInfo (String sceneName) {
        try {
            Field variable = SceneHandler.class.getDeclaredField(sceneName + "Scene"); // bierze zmienną o nazwie <sceneName>Scene
            if (variable.get(null) == null) { // jeżeli scena nie została jeszcze wczytana
                SceneInfo returnValue = new SceneInfo(sceneName, new FXMLLoader(), null);
                returnValue.loader.setLocation(SceneHandler.class.getResource(sceneName + ".fxml"));
                if (returnValue.loader.getLocation() == null)
                    throw new IOException("Nieudana próba wczytania " + sceneName + ".fxml", null);
                returnValue.scene = new Scene(returnValue.loader.load(), App.vSize, App.hSize);
                variable.set(null, returnValue);
                return returnValue;
            }
            else
                return (SceneInfo)variable.get(null);
        }
        catch (NoSuchFieldException nsfe) {
            System.err.println("Nie znaleziono zmiennej '" + sceneName + "Scene'. Msg: " + nsfe.getLocalizedMessage());
        }
        catch (IllegalAccessException iae) {
            System.err.println("Brak dostępu do zmiennej '" + sceneName + "Scene' Msg: " + iae.getLocalizedMessage());
        }
        catch (IOException ioe) {
            System.err.println("Błąd ładowania pliku '" + sceneName + ".fxml' Msg: " + ioe.getLocalizedMessage());
        }
        return null;
    }

    public static void showScene (String sceneName) {
        App.stage.setScene(getSceneInfo(sceneName).scene);
        App.stage.show();
    }
}
