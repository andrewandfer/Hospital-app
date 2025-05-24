package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Este metodo nos permite cambiar entre interfaces sin necesidad de estarlas cerrando y abriendo
//Cada vez que necesitamos
public class SceneManager {
    public static void cambiarEscena(Stage stage, String rutaFXML, Administrador administradorActual) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/"+rutaFXML));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

    public static void cambiarEscenaConDatos(Stage stage, String rutaFXML, Administrador administradorActual, Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/" + rutaFXML));
            Parent root = loader.load();

            // Obtener el nuevo controlador y pasarle el paciente si se puede
            Object controller = loader.getController();

            // Verificar si el controlador tiene el método "setPacienteActualizar"
            if (controller instanceof ActualizarDatosConsultarViewController) {
                ((ActualizarDatosConsultarViewController) controller).setPacienteActualizar(paciente);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Error al cambiar de escena: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void cambiarEscenaConPaciente(Stage stage, String fxml, Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/" + fxml));
            Parent root = loader.load();

            // Obtener el controlador de la nueva escena
            HistorialMedicoViewController controller = loader.getController();

            // Pasar el paciente al nuevo controlador
            controller.mostrarPaciente(paciente);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static Administrador administradorActual;

    public static Administrador getAdministradorActual() {
        return administradorActual;
    }

    public static void setAdministradorActual(Administrador administrador) {
        administradorActual = administrador;
    }


}