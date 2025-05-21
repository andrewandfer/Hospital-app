package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController.ControladorConAdministrador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static Administrador administrador;

    public static void setAdministrador(Administrador admin) {
        administrador = admin;
    }

    public static Administrador getAdministrador() {
        return administrador;
    }

    public static void cambiarEscena(Stage stage, String fxmlPath, Administrador administrador) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/" + fxmlPath));
            Parent root = fxmlLoader.load();

            Object controller = fxmlLoader.getController();

            if (controller instanceof ControladorConAdministrador) {
                ((ControladorConAdministrador) controller).setAdministrador(administrador);
            }

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Administrador getAdmin() {
        return administrador;
    }

}
