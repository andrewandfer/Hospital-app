package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CancelarCitaPacientevc {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtIdCita;

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnCancelar(ActionEvent event) {

        if(txtIdCita.getText().isEmpty()) {
            mostrarAlerta("Por favor, ingrese el ID de la cita a cancelar.", Alert.AlertType.WARNING);
            return;
        }

        if(HospitalAppApplication.hospital.getGestorCitas().cancelarCita(txtIdCita.getText())){
            mostrarAlerta("Cita cancelada exitosamente", Alert.AlertType.INFORMATION);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
        }

        if(!HospitalAppApplication.hospital.getGestorCitas().cancelarCita(txtIdCita.getText())){
            mostrarAlerta("No se pudo cancelar la cita. Verifique el ID ingresado.", Alert.AlertType.INFORMATION);
        }

    }


    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));

        alert.showAndWait();
    }

}

