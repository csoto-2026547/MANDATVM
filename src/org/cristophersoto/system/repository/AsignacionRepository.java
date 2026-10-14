package org.cristophersoto.system.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.cristophersoto.system.config.ConexionDB;
import org.cristophersoto.system.model.AsignacionPractica;
import org.cristophersoto.system.model.dto.AsignacionDTO;

public class AsignacionRepository {

    public void crear(AsignacionPractica asignacion) throws SQLException {
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (CallableStatement cs = conexion.prepareCall("{call sp_crear_asignacion(?, ?, ?, ?)}")) {
            cs.setString(1, asignacion.getNombreAlumno());
            cs.setString(2, asignacion.getNombreEmpresa());
            cs.setString(3, asignacion.getTelefonoOficina());
            cs.setInt(4, asignacion.getIdSector());
            cs.execute();
        }
    }

    public void actualizar(AsignacionPractica asignacion) throws SQLException {
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (CallableStatement cs = conexion.prepareCall("{call sp_actualizar_asignacion(?, ?, ?, ?, ?)}")) {
            cs.setInt(1, asignacion.getIdAsignacion());
            cs.setString(2, asignacion.getNombreAlumno());
            cs.setString(3, asignacion.getNombreEmpresa());
            cs.setString(4, asignacion.getTelefonoOficina());
            cs.setInt(5, asignacion.getIdSector());
            cs.execute();
        }
    }

    public void eliminar(int idAsignacion) throws SQLException {
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (CallableStatement cs = conexion.prepareCall("{call sp_eliminar_asignacion(?)}")) {
            cs.setInt(1, idAsignacion);
            cs.execute();
        }
    }

    public List<AsignacionDTO> listar() throws SQLException {
        List<AsignacionDTO> lista = new ArrayList<>();
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (PreparedStatement ps = conexion.prepareStatement("select id_asignacion, nombre_alumno, nombre_empresa, telefono_oficina, id_sector, nombre_rubro from view_read_asignacion");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new AsignacionDTO(
                        rs.getInt("id_asignacion"),
                        rs.getString("nombre_alumno"),
                        rs.getString("nombre_empresa"),
                        rs.getString("telefono_oficina"),
                        rs.getInt("id_sector"),
                        rs.getString("nombre_rubro")));
            }
        }
        return lista;
    }
}
