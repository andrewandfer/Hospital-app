package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    void OnGenerarReporte(ActionEvent event) {

    }

    @FXML
    void OnGestionarMedicos(ActionEvent event) {

    }

    @FXML
    void OnGestionarPacientes(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/GestionPaciente.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Hospital UQ-Gestion de Pacientes");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    @FXML
    void OnGestionarSalaYHorarios(ActionEvent event) {

    }

}
