package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Cita;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class GenerarReportesViewController {

    @FXML
    private ChoiceBox<Medico> choiceMedico;
    @FXML
    private ChoiceBox<Cita> choiceCita;
    @FXML
    private DatePicker dateFechaCita;
    @FXML
    private TextField txtHoraCita;
    @FXML
    private TextField txtMotivoCita;
    @FXML
    private ChoiceBox<Estado> choiceEstadoCita;
    @FXML
    private TextArea txtMotivosCambio;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;

    private ObservableList<Medico> medicos = FXCollections.observableArrayList();
    private ObservableList<Cita> citas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        List<Medico> listaMedicos = HospitalAppApplication.hospital.getMedicosHospital();
        medicos.setAll(listaMedicos);
        choiceMedico.setItems(medicos);

        choiceEstadoCita.setItems(FXCollections.observableArrayList(Estado.values()));

        choiceMedico.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            cargarCitasDeMedico(newVal);
            limpiarCamposCita();
        });

        choiceCita.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                LocalDateTime fechaHora = newVal.getFechaHoraCita();
                dateFechaCita.setValue(fechaHora != null ? fechaHora.toLocalDate() : null);
                txtHoraCita.setText(fechaHora != null ? fechaHora.toLocalTime().toString() : "");
                txtMotivoCita.setText(""); // No hay campo motivo en Cita según tu modelo
                choiceEstadoCita.setValue(newVal.getEstado());
            } else {
                limpiarCamposCita();
            }
        });

        btnGuardar.setOnAction(e -> guardarCambios());
        btnCancelar.setOnAction(e -> cancelar());
    }

    private void guardarCambios() {
        Cita cita = choiceCita.getValue();
        if (cita != null) {
            LocalDate fecha = dateFechaCita.getValue();
            String horaStr = txtHoraCita.getText();
            LocalTime hora = (horaStr != null && !horaStr.isEmpty()) ? LocalTime.parse(horaStr) : null;
            LocalDateTime nuevaFechaHora = (fecha != null && hora != null) ? LocalDateTime.of(fecha, hora) : null;
            Estado nuevoEstado = choiceEstadoCita.getValue();
            String motivoCambio = txtMotivosCambio.getText();

            HospitalAppApplication.hospital.getGestorCitas()
                    .notificarCambioCita(cita, nuevoEstado, nuevaFechaHora, motivoCambio);

            // Mostrar alerta de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("La cita se guardó correctamente.");
            alert.showAndWait();
        }
    }

    private void cancelar() {
        choiceMedico.getSelectionModel().clearSelection();
        citas.clear();
        choiceCita.setItems(citas);
        limpiarCamposCita();
        txtMotivosCambio.clear();
    }

    private void limpiarCamposCita() {
        dateFechaCita.setValue(null);
        txtHoraCita.clear();
        txtMotivoCita.clear();
        choiceEstadoCita.setValue(null);
    }
    private void cargarCitasDeMedico(Medico medico) {
        if (medico != null) {
            List<Cita> citasMedico = medico.getCitasAsignadas(); // Asumiendo que existe este método
            citas.setAll(citasMedico);
            choiceCita.setItems(citas);
        } else {
            citas.clear();
            choiceCita.setItems(citas);
        }
    }
}