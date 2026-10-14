package org.cristophersoto.system.utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void cambiarEscena(String ruta, String titulo) {
        Parent root = ViewFactory.cargar(ruta);
        stage.setTitle(titulo);
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }
}
