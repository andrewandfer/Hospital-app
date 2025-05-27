package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class GestionarHistorialMedicoPacienteViewController {

    @FXML
    private ComboBox<Medico> comboMedicos;

    @FXML
    private ComboBox<Paciente> comboPacientes;

    @FXML
    private TextArea txtHistorial;

    @FXML
    public void initialize() {
        ObservableList<Medico> medicos = FXCollections.observableArrayList(
                HospitalAppApplication.hospital.getMedicosHospital()
        );
        comboMedicos.setItems(medicos);

        comboMedicos.setOnAction(e -> cargarPacientes());
        comboPacientes.setOnAction(e -> mostrarHistorial());
    }

    private void cargarPacientes() {
        Medico medicoSeleccionado = comboMedicos.getValue();
        if (medicoSeleccionado != null) {
            ObservableList<Paciente> pacientes = FXCollections.observableArrayList(
                    HospitalAppApplication.hospital.getPacientesPorMedico(medicoSeleccionado)
            );
            comboPacientes.setItems(pacientes);
            comboPacientes.setValue(null);
            txtHistorial.clear();
        }
    }

    private void mostrarHistorial() {
        Paciente pacienteSeleccionado = comboPacientes.getValue();
        Medico medicoSeleccionado = comboMedicos.getValue();
        if (pacienteSeleccionado != null && medicoSeleccionado != null) {
            String historial = HospitalAppApplication.hospital.obtenerHistorialMedico(medicoSeleccionado, pacienteSeleccionado);
            txtHistorial.setText(historial != null ? historial : "No hay historial disponible.");
        } else {
            txtHistorial.clear();
        }
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        comboMedicos.setValue(null);
        comboPacientes.setItems(FXCollections.emptyObservableList());
        comboPacientes.setValue(null);
        txtHistorial.clear();
    }
    @FXML
    void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Medico.fxml",SceneManager.getAdministradorActual());
    }
}
