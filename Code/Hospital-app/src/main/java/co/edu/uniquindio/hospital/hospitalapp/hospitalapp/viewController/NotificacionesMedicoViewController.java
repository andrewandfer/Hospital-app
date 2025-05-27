package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Notificacion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NotificacionesMedicoViewController implements Initializable {

    @FXML
    private ComboBox<Medico> comboMedicos;
    @FXML
    private ListView<String> listNotificaciones;
    @FXML
    private Button btnCargarNotificaciones;
    @FXML
    private Button btnMarcarLeidas;

    private List<Medico> medicos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCargarNotificaciones.setDisable(true);
        btnMarcarLeidas.setDisable(true);
        listNotificaciones.setItems(FXCollections.observableArrayList());

        comboMedicos.setOnAction(event -> {
            btnCargarNotificaciones.setDisable(false);
            btnMarcarLeidas.setDisable(false);
            listNotificaciones.getItems().clear();
        });
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
        if (comboMedicos != null && medicos != null) {
            comboMedicos.setItems(FXCollections.observableArrayList(medicos));
        }
    }

    @FXML
    private void onCargarNotificaciones() {
        Medico medicoActual = comboMedicos.getValue();
        listNotificaciones.getItems().clear();

        if (medicoActual == null) {
            mostrarAlerta("Selecciona un médico primero.", Alert.AlertType.WARNING);
            return;
        }

        List<Notificacion> notificaciones = medicoActual.getNotificacionessoobrecitas();

        if (notificaciones != null && !notificaciones.isEmpty()) {
            for (Notificacion n : notificaciones) {
                listNotificaciones.getItems().add(n.getMensaje());
            }
        } else {
            mostrarAlerta("No hay notificaciones nuevas para este médico.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void onMarcarLeidas() {
        Medico medicoActual = comboMedicos.getValue();

        if (medicoActual == null) {
            mostrarAlerta("Selecciona un médico primero.", Alert.AlertType.WARNING);
            return;
        }

        List<Notificacion> notificaciones = medicoActual.getNotificacionessoobrecitas();

        if (notificaciones != null && !notificaciones.isEmpty()) {
            notificaciones.clear();
            listNotificaciones.getItems().clear();
            mostrarAlerta("Todas las notificaciones han sido marcadas como leídas.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("No hay notificaciones para marcar como leídas.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void onBack() {
        Stage stage = (Stage) listNotificaciones.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Notificaciones");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}