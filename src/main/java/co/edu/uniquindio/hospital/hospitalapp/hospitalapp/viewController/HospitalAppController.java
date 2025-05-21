package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;


import java.io.IOException;

public class HospitalAppController {

    @FXML
    private Button btnAdministrador;

    @FXML
    private Button btnMedico;

    @FXML
    private Button btnPaciente;

    @FXML
    private Label welcomeText;

    @FXML
    void onAdministrador(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Administrador.fxml",SceneManager.getAdministrador());


    }

    @FXML
    void onMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Medico.fxml",SceneManager.getAdministrador());



    }

    @FXML
    void onPaciente(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml",SceneManager.getAdministrador());

    }
}
