package org.cristophersoto.system.model;

public class AsignacionPractica {

    private int idAsignacion;
    private String nombreAlumno;
    private String nombreEmpresa;
    private String telefonoOficina;
    private int idSector;

    public AsignacionPractica(int idAsignacion, String nombreAlumno, String nombreEmpresa, String telefonoOficina, int idSector) {
        this.idAsignacion = idAsignacion;
        this.nombreAlumno = nombreAlumno;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoOficina = telefonoOficina;
        this.idSector = idSector;
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
}
