package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HistorialMedicoViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnConsultarHistorialMedico;

    @FXML
    private TextField btnIdHistorial;

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "hospitalapp-view.fxml");
    }

    @FXML
    void OnConsultarHistorialMedico(ActionEvent event) {

    }

}

