package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class SolicitarCitaPacienteViewController {

    @FXML
    private ChoiceBox<Medico> ChoiceBoxMedico;

    @FXML
    private DatePicker DatePickerFecha;

    @FXML
    private Button btnListo;

    @FXML
    private TextField txtIngreseid;

    @FXML
    private Button btnAtras;

    @FXML
    private Spinner<Integer> spnrHora;

    @FXML
    public void initialize() {
        ChoiceBoxMedico.setItems(FXCollections.observableArrayList(
                HospitalAppApplication.hospital.getMedicosHospital()
        ));

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12);
        spnrHora.setValueFactory(valueFactory);
    }


    @FXML
    void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void OnListo(ActionEvent event) {

        if(txtIngreseid.getText().isEmpty() || ChoiceBoxMedico.getValue() == null || DatePickerFecha.getValue() == null) {
            mostrarAlerta("Por favor, complete todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        Paciente paciente = HospitalAppApplication.hospital.buscarPaciente(txtIngreseid.getText());
        Medico medico = ChoiceBoxMedico.getValue();
        LocalDate fecha = DatePickerFecha.getValue();
        int hora = spnrHora.getValue();

        LocalDateTime fechaHora = fecha.atTime(hora, 0);

        String idCita = HospitalAppApplication.hospital.getGestorCitas().solicitarCita(paciente, medico, fechaHora);
        mostrarAlerta("Cita solicitada con exito, ID de la cita: " + idCita, Alert.AlertType.INFORMATION);

        System.out.println("Solicitud de cita realizada con éxito.");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());

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