package org.cristophersoto.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.cristophersoto.system.model.*;
import org.cristophersoto.system.model.dto.AsignacionDTO;
import org.cristophersoto.system.service.*;
import org.cristophersoto.system.utils.*;

public class MainMenuController {

    @FXML private TextField txtAlumno;
    @FXML private TextField txtEmpresa;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<SectorEmpresarial> cmbSector;
    @FXML private TableView<AsignacionDTO> tblAsignaciones;
    @FXML private TableColumn<AsignacionDTO, String> colAlumno;
    @FXML private TableColumn<AsignacionDTO, String> colEmpresa;
    @FXML private TableColumn<AsignacionDTO, String> colTelefono;
    @FXML private TableColumn<AsignacionDTO, String> colSector;

    private AsignacionService asignacionService = new AsignacionService();
    private SectorService sectorService = new SectorService();

    @FXML
    private void initialize() {
        colAlumno.setCellValueFactory(new PropertyValueFactory<>("nombreAlumno"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresa"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefonoOficina"));
        colSector.setCellValueFactory(new PropertyValueFactory<>("nombreRubro"));
        tblAsignaciones.getSelectionModel().selectedItemProperty().addListener((obs, anterior, dto) -> {
            if (dto != null) {
                llenarFormulario(dto);
            }
        });
        cargar();
    }

    @FXML
    private void guardar() {
        registrar(false);
    }

    @FXML
    private void actualizar() {
        registrar(true);
    }

    @FXML
    private void eliminar() {
        AsignacionDTO seleccionado = tblAsignaciones.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mensaje("selecciona una asignacion de la tabla");
            return;
        }
        try {
            asignacionService.eliminar(seleccionado.getIdAsignacion());
            limpiar();
            cargar();
        } catch (Exception e) {
            mensaje("no se pudo eliminar: " + e.getMessage());
        }
    }

    @FXML
    private void limpiar() {
        txtAlumno.clear();
        txtEmpresa.clear();
        txtTelefono.clear();
        cmbSector.setValue(null);
        tblAsignaciones.getSelectionModel().clearSelection();
    }

    @FXML
    private void salir() {
        ViewFactory.mostrarLogin();
    }

    private void registrar(boolean actualizando) {
        AsignacionDTO seleccionado = tblAsignaciones.getSelectionModel().getSelectedItem();
        if (actualizando && seleccionado == null) {
            mensaje("selecciona una asignacion de la tabla");
            return;
        }
        if (!datosValidos()) {
            return;
        }
        int id = actualizando ? seleccionado.getIdAsignacion() : 0;
        AsignacionPractica asignacion = new AsignacionPractica(id, txtAlumno.getText().trim(), txtEmpresa.getText().trim(),
                txtTelefono.getText().trim(), cmbSector.getValue().getIdSector());
        try {
            if (actualizando) {
                asignacionService.actualizar(asignacion);
            } else {
                asignacionService.guardar(asignacion);
            }
            limpiar();
            cargar();
        } catch (Exception e) {
            mensaje("no se pudo completar la accion: " + e.getMessage());
        }
    }

    private void cargar() {
        try {
            cmbSector.getItems().setAll(sectorService.listar());
            tblAsignaciones.getItems().setAll(asignacionService.listar());
        } catch (Exception e) {
            mensaje("no se pudieron cargar los datos: " + e.getMessage());
        }
    }

    private void llenarFormulario(AsignacionDTO dto) {
        txtAlumno.setText(dto.getNombreAlumno());
        txtEmpresa.setText(dto.getNombreEmpresa());
        txtTelefono.setText(dto.getTelefonoOficina());
        for (SectorEmpresarial sector : cmbSector.getItems()) {
            if (sector.getIdSector() == dto.getIdSector()) {
                cmbSector.setValue(sector);
            }
        }
    }

    private boolean datosValidos() {
        String alumno = txtAlumno.getText();
        String empresa = txtEmpresa.getText();
        String telefono = txtTelefono.getText();
        if (Validations.vacio(alumno) || Validations.vacio(empresa) || Validations.vacio(telefono) || cmbSector.getValue() == null) {
            mensaje("completa todos los campos y elige un sector");
            return false;
        }
        if (Validations.superaLongitud(alumno, Validations.MAX_ALUMNO) || Validations.superaLongitud(empresa, Validations.MAX_EMPRESA)
                || Validations.superaLongitud(telefono, Validations.MAX_TELEFONO)) {
            mensaje("maximo de caracteres: alumno " + Validations.MAX_ALUMNO + ", empresa " + Validations.MAX_EMPRESA
                    + ", telefono " + Validations.MAX_TELEFONO);
            return false;
        }
        return true;
    }

    private void mensaje(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, texto);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
}
