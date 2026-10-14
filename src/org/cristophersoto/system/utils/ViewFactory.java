package org.cristophersoto.system.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewFactory {

    public static final String LOGIN = "/org/cristophersoto/system/view/LoginView.fxml";
    public static final String MENU = "/org/cristophersoto/system/view/MainMenuView.fxml";

    public static Parent cargar(String ruta) {
        try {
            return FXMLLoader.load(ViewFactory.class.getResource(ruta));
        } catch (IOException e) {
            throw new IllegalStateException("no se pudo cargar la vista " + ruta, e);
        }
    }

    public static void mostrarLogin() {
        SceneManager.cambiarEscena(LOGIN, "mandatvm - login");
    }
}
