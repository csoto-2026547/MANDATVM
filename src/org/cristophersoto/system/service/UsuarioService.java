package org.cristophersoto.system.service;

import org.cristophersoto.system.model.LoginResult;
import org.cristophersoto.system.model.Usuario;
import org.cristophersoto.system.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public LoginResult login(String userName, String userPassword) {
        try {
            Usuario usuario = usuarioRepository.validar(userName, userPassword);
            if (usuario == null) {
                return LoginResult.INCORRECTO;
            }
            if (!usuario.isUserStatus()) {
                return LoginResult.INACTIVO;
            }
            return LoginResult.CORRECTO;
        } catch (Exception e) {
            e.printStackTrace();
            return LoginResult.ERROR_CONEXION;
        }
    }
}
