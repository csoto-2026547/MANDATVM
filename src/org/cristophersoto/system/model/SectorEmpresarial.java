package org.cristophersoto.system.model;

public class SectorEmpresarial {

    private int idSector;
    private String nombreRubro;
    private String encargadoContacto;

    public SectorEmpresarial(int idSector, String nombreRubro, String encargadoContacto) {
        this.idSector = idSector;
        this.nombreRubro = nombreRubro;
        this.encargadoContacto = encargadoContacto;
    }

    public int getIdSector() {
        return idSector;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public String getEncargadoContacto() {
        return encargadoContacto;
    }

    @Override
    public String toString() {
        return nombreRubro;
    }
}
