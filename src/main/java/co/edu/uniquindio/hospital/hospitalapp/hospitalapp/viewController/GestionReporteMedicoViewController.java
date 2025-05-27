package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Cita;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GestionReporteMedicoViewController {

    @FXML
    private ComboBox<Medico> comboMedicos;
    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, String> colPaciente;
    @FXML
    private TableColumn<Cita, String> colFecha;
    @FXML
    private TableColumn<Cita, String> colHora;
    @FXML
    private TableColumn<Cita, String> colMotivo;
    @FXML
    private TextArea txtReporte;

    private ObservableList<Cita> citasMedico = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        comboMedicos.setItems(FXCollections.observableArrayList(
                HospitalAppApplication.hospital.getMedicosHospital()
        ));

        colPaciente.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getPaciente().getNombre())
        );
        colFecha.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getFechaHoraCita().toLocalDate().toString())
        );
        colHora.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getFechaHoraCita().toLocalTime().toString())
        );

        tablaCitas.setItems(citasMedico);

        comboMedicos.setOnAction(e -> cargarCitasMedico());
    }

    private void cargarCitasMedico() {
        Medico medico = comboMedicos.getValue();
        citasMedico.clear();
        if (medico != null && medico.getCitasAsignadas() != null) {
            citasMedico.addAll(medico.getCitasAsignadas());
        }
    }

    @FXML
    private void onGuardarReporte() {
        Cita citaSeleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        String reporte = txtReporte.getText();

        if (citaSeleccionada == null) {
            mostrarAlerta("Seleccione una cita para guardar el reporte.");
            return;
        }
        if (reporte == null || reporte.isBlank()) {
            mostrarAlerta("El reporte no puede estar vacío.");
            return;
        }

        // Aquí deberías guardar el reporte en el modelo de datos correspondiente
        // Por ejemplo: citaSeleccionada.setReporte(reporte);

        mostrarAlertaInfo("Reporte guardado correctamente.");
        txtReporte.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void mostrarAlertaInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}