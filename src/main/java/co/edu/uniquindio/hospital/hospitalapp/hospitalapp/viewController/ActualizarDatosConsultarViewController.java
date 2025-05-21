package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;

public class ActualizarDatosConsultarViewController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField txtId;

    @FXML
    void OnConsultar(ActionEvent event) {

    }

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }
}

