package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    private Button btnBack;
    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "hospitalapp-view.fxml");

    }

    @FXML
    void OnGenerarReporte(ActionEvent event) {

    }

    @FXML
    void OnGestionarMedicos(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/GestionMedico.fxml"));
//            Parent root = loader.load();
//
//            Stage stage = new Stage();
//            stage.setTitle("Hospital UQ-Administrador-GestionMedicos");
//            Image icon = new Image(getClass().getResourceAsStream("/imagenes/logo.png"));
//            stage.getIcons().add(icon);
//            stage.setScene(new Scene(root));
//            stage.show();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionMedico.fxml");

    }

    @FXML
    void OnGestionarPacientes(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionPaciente.fxml");

    }

    @FXML
    void OnGestionarSalaYHorarios(ActionEvent event) {

    }

}
