package org.cristophersoto.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.cristophersoto.system.model.LoginResult;
import org.cristophersoto.system.service.UsuarioService;
import org.cristophersoto.system.utils.*;

public class LoginController {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMensaje;

    private UsuarioService usuarioService = new UsuarioService();

    @FXML
    private void ingresar() {
        if (Validations.vacio(txtUser.getText()) || Validations.vacio(txtPassword.getText())) {
            lblMensaje.setText("escribe tu usuario y tu clave");
            return;
        }
        LoginResult resultado = usuarioService.login(txtUser.getText().trim(), txtPassword.getText());
        switch (resultado) {
            case CORRECTO:
                SceneManager.cambiarEscena(ViewFactory.MENU, "mandatvm - panel de practicas");
                break;
            case INCORRECTO:
                lblMensaje.setText("usuario o clave incorrectos");
                break;
            case INACTIVO:
                lblMensaje.setText("el usuario esta inactivo");
                break;
            case ERROR_CONEXION:
                lblMensaje.setText("no se pudo conectar a la base de datos");
                break;
        }
    }
}
