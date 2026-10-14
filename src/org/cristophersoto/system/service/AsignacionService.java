package org.cristophersoto.system.service;

import java.sql.SQLException;
import java.util.List;
import org.cristophersoto.system.model.AsignacionPractica;
import org.cristophersoto.system.model.dto.AsignacionDTO;
import org.cristophersoto.system.repository.AsignacionRepository;

public class AsignacionService {

    private AsignacionRepository asignacionRepository = new AsignacionRepository();

    public void guardar(AsignacionPractica asignacion) throws SQLException {
        asignacionRepository.crear(asignacion);
    }

    public void actualizar(AsignacionPractica asignacion) throws SQLException {
        asignacionRepository.actualizar(asignacion);
    }

    public void eliminar(int idAsignacion) throws SQLException {
        asignacionRepository.eliminar(idAsignacion);
    }

    public List<AsignacionDTO> listar() throws SQLException {
        return asignacionRepository.listar();
    }
}
