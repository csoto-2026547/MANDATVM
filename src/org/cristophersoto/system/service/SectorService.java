package org.cristophersoto.system.service;

import java.sql.SQLException;
import java.util.List;
import org.cristophersoto.system.model.SectorEmpresarial;
import org.cristophersoto.system.repository.SectorRepository;

public class SectorService {

    private SectorRepository sectorRepository = new SectorRepository();

    public List<SectorEmpresarial> listar() throws SQLException {
        return sectorRepository.listar();
    }
}
