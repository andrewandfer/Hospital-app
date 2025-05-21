package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    void OnCambiarDisponibilidad(ActionEvent event) {

    }
    @FXML
    void OnAsignarMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "AsignarPacienteMedico.fxml",SceneManager.getAdministradorActual());

    }

    @FXML
    private Button btnBack;
    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "hospitalapp-view.fxml",SceneManager.getAdministradorActual());

    }

    @FXML
    void OnGenerarReporte(ActionEvent event) {

    }

    @FXML
    void OnGestionarMedicos(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionMedico.fxml",SceneManager.getAdministradorActual());

    }

    @FXML
    void OnGestionarPacientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/GestionPaciente.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el administrador
            GestionPacienteViewController controller = loader.getController();
            // ✅ Esta es la clave

            // Cambiar escena
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

    }
    private Administrador administrador;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;

    }


}
