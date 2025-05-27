package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {

    private static Administrador administradorActual;
    private static MedicoViewController medicoViewController;

    public static Administrador getAdministradorActual() {
        return administradorActual;
    }

    public static void setAdministradorActual(Administrador administrador) {
        administradorActual = administrador;
    }

    public static MedicoViewController getMedicoViewController() {
        return medicoViewController;
    }

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

            Object controller = loader.getController();

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
            HistorialMedicoViewController controller = loader.getController();
            controller.mostrarPaciente(paciente);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cambiarEscenaConMedico(Stage stage, String fxml, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(
                    "/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/" + fxml));
            Parent root = loader.load();

            Object controller = loader.getController();
            if (controller instanceof MedicoViewController) {
                ((MedicoViewController) controller).setMedico(medico);
                medicoViewController = (MedicoViewController) controller; // Guardar instancia
                ((MedicoViewController) controller).notificarCambioCita(SceneManager.medico);
            } else if (controller instanceof MedicoRegistrarHistorialMedicoViewController) {
                ((MedicoRegistrarHistorialMedicoViewController) controller).setMedico(medico);
                // Si necesitas notificar aquí, crea otra variable estática similar
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}