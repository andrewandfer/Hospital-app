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

public class ActualizarDatosConsultarViewController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField txtId;

    @FXML
    void OnConsultar(ActionEvent event) {

        if(txtId.getText() == ""){
            mostrarAlerta("Por favor, ingrese un ID");
        }
        for(Paciente paciente : HospitalAppApplication.hospital.getPacientes()){
            if(paciente.getId().equals(txtId.getText())){
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                SceneManager.cambiarEscena(stage, "ActualizarDatosPaciente.fxml", SceneManager.getAdministradorActual());

                return;
            } else{
                mostrarAlerta("No se ncontró el paciente");
            }
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

    @FXML
    void onActualizarPaciente(ActionEvent event) {

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

