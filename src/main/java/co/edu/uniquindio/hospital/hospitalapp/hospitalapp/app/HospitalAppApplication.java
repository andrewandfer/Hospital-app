package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HospitalAppApplication extends Application {

    Administrador administrador = new Administrador("Admin", "Principal", "admin1");

    @Override
    public void start(Stage stage) throws IOException {
        // 🔥 Aquí registras el administrador para acceso global
        SceneManager.setAdministrador(administrador);

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalAppApplication.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/hospitalapp-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.getIcons().add(new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/imagenes/logo.png")
        )));

        stage.setTitle("HOSPITAL UQ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
