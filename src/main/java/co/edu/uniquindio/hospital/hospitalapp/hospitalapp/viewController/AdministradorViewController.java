package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministradorViewController {

    @FXML
    private Button btnGenerarReporte;

    @FXML
    private Button btnGestionarMedicos;

    @FXML
    private Button btnGestionarPacientes;

    @FXML
    private Button btnGestionarSalaYHorario;

    @FXML
    private Button btnAsignarMedico;

    @FXML
    private Button btnDisponibilidadMedicos;

    @FXML
    private Button btnBack;

    private Administrador administrador;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @FXML
    void OnCambiarDisponibilidad(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionarDisponibilidadMedico.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnAsignarMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "AsignarPacienteMedico.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Hospitalapp-view.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnGenerarReporte(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GenerarReportes.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnGestionarMedicos(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionMedico.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnGestionarPacientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/GestionPaciente.fxml"));
            Parent root = loader.load();
            GestionPacienteViewController controller = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Pacientes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnGestionarSalaYHorarios(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionarSalaHorarios.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void onGestionarMedico(ActionEvent event) {
        // Implementar si es necesario
    }

    // Método correcto para notificar al médico que ya tiene la interfaz abierta
    @FXML
    void notificarAlMedico(ActionEvent event) {
        var medicoController = SceneManager.getMedicoViewController();
        if (medicoController != null) {
            medicoController.notificarCambioCita("Se ha modificado una cita. Por favor, revise los cambios.");
        }
    }
}