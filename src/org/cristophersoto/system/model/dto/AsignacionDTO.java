package org.cristophersoto.system.model.dto;

public class AsignacionDTO {

    private int idAsignacion;
    private String nombreAlumno;
    private String nombreEmpresa;
    private String telefonoOficina;
    private int idSector;
    private String nombreRubro;

    public AsignacionDTO(int idAsignacion, String nombreAlumno, String nombreEmpresa, String telefonoOficina, int idSector, String nombreRubro) {
        this.idAsignacion = idAsignacion;
        this.nombreAlumno = nombreAlumno;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoOficina = telefonoOficina;
        this.idSector = idSector;
        this.nombreRubro = nombreRubro;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public int getIdSector() {
        return idSector;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }
}
