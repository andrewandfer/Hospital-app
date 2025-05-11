package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.io.IOException;

public class HospitalAppController {

    @FXML
    private Button btnAdministrador;

    @FXML
    private Button btnMedico;

    @FXML
    private Button btnPaciente;

    @FXML
    private Label welcomeText;

    @FXML
    void onAdministrador(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/Administrador.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Administrador");
            Image icon = new Image(getClass().getResourceAsStream("/imagenes/logo.png"));
            stage.getIcons().add(icon);

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void onMedico(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/Medico.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Medico");
            Image icon = new Image(getClass().getResourceAsStream("/imagenes/logo.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void onPaciente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/Paciente.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Paciente");
            Image icon = new Image(getClass().getResourceAsStream("/imagenes/logo.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
