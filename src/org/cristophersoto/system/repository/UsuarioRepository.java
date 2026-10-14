package org.cristophersoto.system.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cristophersoto.system.config.ConexionDB;
import org.cristophersoto.system.model.Usuario;

public class UsuarioRepository {

    public Usuario validar(String userName, String userPassword) throws SQLException {
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (CallableStatement cs = conexion.prepareCall("{call sp_validar_usuario(?, ?)}")) {
            cs.setString(1, userName);
            cs.setString(2, userPassword);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(rs.getInt("id_usuario"), rs.getString("user_name"), rs.getBoolean("user_status"));
                }
            }
        }
        return null;
    }
}
