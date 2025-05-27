package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MedicoViewController {

    private Medico medico;

    public void setMedico(Medico medico) {
        this.medico = medico;
        // Aquí puedes cargar info relacionada al médico (nombre, especialidad, etc.)
    }

    @FXML
    private Button btnAdministrarHorarios;

    @FXML
    private Button btnGestionarHistorialMedico;

    @FXML
    private Button btnNotificarCambios;

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

    @FXML
    void OnNotificarcambios(ActionEvent event) {
        // Acción para notificar cambios
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

