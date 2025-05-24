package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;
import java.time.LocalDate;

public class ActualizarDatosConsultarViewController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField txtId;

    Paciente pacienteActualizar;


    @FXML
    void OnConsultar(ActionEvent event) {
        if (txtId.getText().isEmpty()) {
            mostrarAlerta("Por favor, ingrese un ID");
            return;
        }

        for (Paciente paciente : HospitalAppApplication.hospital.getPacientes()) {
            if (paciente.getId().equals(txtId.getText())) {

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Nueva forma: pasar el paciente directamente
                SceneManager.cambiarEscenaConDatos(stage, "ActualizarDatosPaciente.fxml", SceneManager.getAdministradorActual(), paciente);
                return;
            }
        }

        mostrarAlerta("No se encontró el paciente");
    }

    public void setPacienteActualizar(Paciente paciente) {
        this.pacienteActualizar = paciente;

        if (txt_apellidoActualizado != null) {
            txt_apellidoActualizado.setText(paciente.getApellido());
        }

        if (txt_nombreActualizado != null) {
            txt_nombreActualizado.setText(paciente.getNombre());
        }

        if (date_fechaActualizada != null && paciente.getFechaNacimiento() != null) {
            date_fechaActualizada.setValue(paciente.getFechaNacimiento());
        }
    }

    @FXML
    public void initialize() {
        if (pacienteActualizar != null && txt_apellidoActualizado != null) {
            txt_apellidoActualizado.setText(pacienteActualizar.getApellido());
            txt_nombreActualizado.setText(pacienteActualizar.getNombre());
        }
    }


    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }



    @FXML
    private Button btnActualizarDatosPaciente;

    @FXML
    private DatePicker date_fechaActualizada;

    @FXML
    private TextField txt_apellidoActualizado;

    @FXML
    private TextField txt_nombreActualizado;


//    pacienteActualizar.setNombre(nombreNuevo);
//        pacienteActualizar.setApellido(apellidoNuevo);
//        pacienteActualizar.setFechaNacimiento(fechaNueva);


    @FXML
    void onActualizarPaciente(ActionEvent event) {

        String idPaciente = pacienteActualizar.getId();
        String nombreNuevo = txt_nombreActualizado.getText();
        String apellidoNuevo = txt_apellidoActualizado.getText();
        LocalDate fechaNueva = date_fechaActualizada.getValue();

        HospitalAppApplication.hospital.actualizarDatosPaciente(idPaciente, nombreNuevo, apellidoNuevo, fechaNueva);

        mostrarAlerta("Datos actualizados correctamente");


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));

        alert.showAndWait();
    }



}

