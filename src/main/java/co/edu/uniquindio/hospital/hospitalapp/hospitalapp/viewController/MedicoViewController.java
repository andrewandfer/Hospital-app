package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MedicoViewController {

    private Medico medico;

    public void setMedico(Medico medico) {
        this.medico = medico;
        // Aquí puedes cargar info relacionada al médico (nombre, especialidad, etc.)
    }

    @FXML
    private Button btnNotificarCambios;

    // Variable para guardar el mensaje de notificación
    private String mensajeNotificacion = "";

    @FXML
    private Button btnAdministrarHorarios;

    @FXML
    private Button btnGestionarHistorialMedico;

    @FXML
    private Button btnRegistrarDiagnosticoTratamiento;

    @FXML
    void OnAdministrarHorarios(ActionEvent event) {
        // Acción para administrar horarios
    }

    @FXML
    void OnGestionarHistorialMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionarHistorialMedicoPaciente.fxml", SceneManager.getAdministradorActual());
    }

    // Método para recibir la notificación desde el administrador
    public void notificarCambioCita(String mensaje) {
        this.mensajeNotificacion = mensaje;
        btnNotificarCambios.setStyle("-fx-background-color: #f39c12;");
    }

    // Método que muestra la notificación al médico
    @FXML
    private void OnNotificarcambios() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notificación");
        alert.setHeaderText("Cambio en una cita");
        alert.setContentText(mensajeNotificacion.isEmpty() ? "No hay notificaciones nuevas." : mensajeNotificacion);
        alert.showAndWait();
        // Limpiar la notificación después de verla
        mensajeNotificacion = "";
        btnNotificarCambios.setStyle("");
    }

    @FXML
    void OnRegistrarDiagnosticoOTratamiento(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscenaConMedico(stage, "MedicoRegistrarHistorialMedico.fxml", medico);
    }

    @FXML
    void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Hospitalapp-view.fxml", SceneManager.getAdministradorActual());
    }
}

