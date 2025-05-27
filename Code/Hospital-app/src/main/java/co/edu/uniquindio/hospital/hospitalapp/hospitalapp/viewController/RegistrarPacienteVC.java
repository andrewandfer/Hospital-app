package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RegistrarPacienteVC {

    @FXML
    private DatePicker DatePickerFechaNacimiento;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnListo;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnListo(ActionEvent event) {

        if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtId.getText().isEmpty() || DatePickerFechaNacimiento.getValue() == null) {
            mostrarAlerta("Por favor, complete todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String id = txtId.getText();
        LocalDate fechaNacimiento = DatePickerFechaNacimiento.getValue();

        if(HospitalAppApplication.hospital.registrarNuevoPaciente(nombre, apellido, id, fechaNacimiento)){
            mostrarAlerta("Paciente registrado exitosamente", Alert.AlertType.INFORMATION);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
        } else {
            mostrarAlerta("Error al registrar el paciente. Verifique los datos ingresados.", Alert.AlertType.ERROR);
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
