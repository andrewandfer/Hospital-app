package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PacienteViewController{

    @FXML
    private Button btnActualizarDatos;

    @FXML
    private Button btnCancelarCitas;

    @FXML
    private Button btnHistorialMedico;

    @FXML
    private Button btnRegistrarCitas;

    @FXML
    private Button btnSolicitarCitas;

    @FXML
    void onActualizarDatos(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "ActualizarDatosConsultar.fxml");

    }

    @FXML
    void onCancelarCitas(ActionEvent event) {


    }

    @FXML
    void onHistorialMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "PacienteHistorialMedico.fxml");

    }

    @FXML
    void onRegistrarCitas(ActionEvent event) {

    }

    @FXML
    void onSolicitarCitas(ActionEvent event) {

    }

}

