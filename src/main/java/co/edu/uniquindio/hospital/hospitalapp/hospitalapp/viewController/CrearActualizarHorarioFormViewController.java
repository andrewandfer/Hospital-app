package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Horario;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CrearActualizarHorarioFormViewController {

    @FXML
    private ComboBox<String> comboDia;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtHoraFin;

    private final ObservableList<Horario> listaHorarios = FXCollections.observableArrayList();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @FXML
    public void initialize() {
        comboDia.getItems().addAll("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
    }

    @FXML
    void onGuardar(ActionEvent event) {
        String dia = comboDia.getValue();
        String horaInicioStr = txtHoraInicio.getText().trim();
        String horaFinStr = txtHoraFin.getText().trim();

        if (dia == null || horaInicioStr.isEmpty() || horaFinStr.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }

        try {
            LocalTime horaInicio = LocalTime.parse(horaInicioStr, formatter);
            LocalTime horaFin = LocalTime.parse(horaFinStr, formatter);

            if (horaFin.isBefore(horaInicio)) {
                mostrarAlerta("La hora de fin debe ser posterior a la hora de inicio.");
                return;
            }

            Horario nuevoHorario = new Horario(dia, horaInicio, horaFin);
            listaHorarios.add(nuevoHorario);
            HospitalAppApplication.hospital.getHorarioAtencion().add(nuevoHorario);
            mostrarAlerta("Horario guardado correctamente.");
            limpiarCampos();

        } catch (DateTimeParseException e) {
            mostrarAlerta("Formato de hora inválido. Usa el formato HH:mm (ej: 08:00).");
        }
    }

    @FXML
    void onCancelar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "GestionarSalaHorarios.fxml", SceneManager.getAdministradorActual());
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));

    }

    private void limpiarCampos() {
        comboDia.setValue(null);
        txtHoraInicio.clear();
        txtHoraFin.clear();
    }

    public ObservableList<Horario> getListaHorarios() {
        return listaHorarios;
    }
}
