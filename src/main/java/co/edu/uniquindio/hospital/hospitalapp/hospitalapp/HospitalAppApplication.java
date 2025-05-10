package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HospitalAppApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalAppApplication.class.getResource("hospitalapp-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Icono personalizado (asegúrate de que el nombre y ruta coincidan exactamente)
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
