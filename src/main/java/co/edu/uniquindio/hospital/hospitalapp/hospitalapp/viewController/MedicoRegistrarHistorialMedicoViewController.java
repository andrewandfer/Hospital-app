package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.EventObject;

public class MedicoRegistrarHistorialMedicoViewController {
    private Medico medico;

    public void setMedico(Medico medico) {
        this.medico = medico;

        if (medico != null) {
            System.out.println("Médico asignado: " + medico.getNombre());
        } else {
            System.out.println("⚠️ ¡El objeto Medico recibido es null!");
        }
    }


    @FXML
    private TextField txtIdHistorialMedico;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtTratamiento;

    @FXML
    private ChoiceBox<String> ChiceBoxPaciente;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnBack;

    // Este método se ejecuta cuando se hace clic en el botón "Registrar"
    @FXML
    private void OnRegistrar() {
        String idHistorial = txtIdHistorialMedico.getText();
        String diagnostico = txtDiagnostico.getText();
        String tratamiento = txtTratamiento.getText();
        String paciente = ChiceBoxPaciente.getValue();

        if (idHistorial.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty() || paciente == null) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        // Aquí va la lógica de registro (por ahora solo mostramos en consola)
        System.out.println("✅ Historial médico registrado:");
        System.out.println("ID: " + idHistorial);
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
        System.out.println("Paciente: " + paciente);

        mostrarAlerta("Éxito", "Historial médico registrado con éxito.");

        // Limpia los campos
        txtIdHistorialMedico.clear();
        txtDiagnostico.clear();
        txtTratamiento.clear();
        ChiceBoxPaciente.setValue(null);
    }

    // Este método opcional podría usarse para manejar el botón "Back"
    @FXML
    private void OnBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Medico.fxml", SceneManager.getAdministradorActual());
    }

    // Método auxiliar para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Este método se puede usar para inicializar cosas al cargar la vista
    @FXML
    public void initialize() {
        // Cargar pacientes de ejemplo (debería venir de la lógica de negocio)
        ChiceBoxPaciente.getItems().addAll(
                "Juan Pérez",
                "Ana García",
                "Carlos Ramírez"
        );
    }
}
