package org.cristophersoto.system.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.cristophersoto.system.config.ConexionDB;
import org.cristophersoto.system.model.SectorEmpresarial;

public class SectorRepository {

    public List<SectorEmpresarial> listar() throws SQLException {
        List<SectorEmpresarial> lista = new ArrayList<>();
        Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
        try (PreparedStatement ps = conexion.prepareStatement("select id_sector, nombre_rubro, encargado_contacto from sectorempresarial");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new SectorEmpresarial(rs.getInt("id_sector"), rs.getString("nombre_rubro"), rs.getString("encargado_contacto")));
            }
        }
        return lista;
    }
}
