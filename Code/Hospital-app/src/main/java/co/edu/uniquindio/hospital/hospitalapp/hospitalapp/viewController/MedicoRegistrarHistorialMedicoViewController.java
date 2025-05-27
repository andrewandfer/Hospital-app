package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.HistorialMedico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MedicoRegistrarHistorialMedicoViewController {
    private Medico medico;

    public void setMedico(Medico medico) {

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

    // Método para registrar el historial médico al paciente seleccionado
    @FXML
    private void OnRegistrar() {
        String idHistorial = txtIdHistorialMedico.getText();
        String diagnostico = txtDiagnostico.getText();
        String tratamiento = txtTratamiento.getText();
        String nombrePaciente = ChiceBoxPaciente.getValue();

        if (idHistorial.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty() || nombrePaciente == null) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        // Buscar el paciente por nombre
        Paciente pacienteSeleccionado = HospitalAppApplication.hospital.getPacientes().stream()
                .filter(p -> (p.getNombre() + " " + p.getApellido()).equals(nombrePaciente))
                .findFirst()
                .orElse(null);

        if (pacienteSeleccionado == null) {
            mostrarAlerta("Error", "No se encontró el paciente seleccionado.");
            return;
        }

        // Crear el historial médico y asignarlo al paciente
        HistorialMedico historial = new HistorialMedico(idHistorial, diagnostico, tratamiento, pacienteSeleccionado);
        pacienteSeleccionado.setHistorialMedico(historial);

        mostrarAlerta("Éxito", "Historial médico registrado para el paciente.");

        // Limpiar campos
        txtIdHistorialMedico.clear();
        txtDiagnostico.clear();
        txtTratamiento.clear();
        ChiceBoxPaciente.setValue(null);
    }

    // Método para volver atrás
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

    // Inicializa la lista de pacientes en el ChoiceBox
    @FXML
    public void initialize() {
        ObservableList<String> nombresPacientes = FXCollections.observableArrayList();
        HospitalAppApplication.hospital.getPacientes().forEach(
                paciente -> nombresPacientes.add(paciente.getNombre() + " " + paciente.getApellido())
        );
        ChiceBoxPaciente.setItems(nombresPacientes);
    }
}

