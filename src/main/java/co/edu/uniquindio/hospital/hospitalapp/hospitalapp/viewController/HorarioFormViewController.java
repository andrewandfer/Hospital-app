package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Horario;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class HorarioFormViewController {

    @FXML
    private TextField txtDia;
    @FXML
    private TextField txtHoraInicio;
    @FXML
    private TextField txtHoraFin;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private ChoiceBox<Medico> choiseMedico;

    @FXML
    public void initialize() {
        choiseMedico.setItems(FXCollections.observableArrayList(
                HospitalAppApplication.hospital.getMedicosHospital()
        ));
        choiseMedico.setConverter(new StringConverter<Medico>() {
            @Override
            public String toString(Medico medico) {
                return medico == null ? "" : medico.getNombre() + " " + medico.getApellido();
            }
            @Override
            public Medico fromString(String s) { return null; }
        });
    }

    @FXML
    private void onGuardar() {
        String dia = txtDia.getText();
        String horaInicioStr = txtHoraInicio.getText();
        String horaFinStr = txtHoraFin.getText();
        Medico medico = choiseMedico.getValue();

        if (dia.isEmpty() || horaInicioStr.isEmpty() || horaFinStr.isEmpty() || medico == null) {
            mostrarAlerta("Campos incompletos", "Por favor complete todos los campos y seleccione un médico.");
            return;
        }

        try {
            LocalTime horaInicio = LocalTime.parse(horaInicioStr);
            LocalTime horaFin = LocalTime.parse(horaFinStr);

            Horario horario = new Horario(dia, horaInicio, horaFin);
            medico.getHorariosAsignados().add(horario);

            mostrarAlertaInfo("Horario asignado", "El horario fue asignado correctamente.");
            irAGestionMedico();
        } catch (DateTimeParseException e) {
            mostrarAlerta("Formato incorrecto", "Las horas deben tener el formato HH:mm (ejemplo: 08:30).");
        }
    }

    @FXML
    private void onCancelar() {
        irAGestionMedico();
    }

    private void irAGestionMedico() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/GestionMedico.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));
            stage.setTitle("Gestión Médico");
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir la ventana de gestión de médico.");
        }
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));
        alerta.showAndWait();
    }

    private void mostrarAlertaInfo(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));
        alerta.showAndWait();
    }
}