package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class GestionarDisponibilidadMedicosViewController {

    @FXML
    private TableView<Medico> tablaMedicos;

    @FXML
    private TableColumn<Medico,String> colNombre;

    @FXML
    private TableColumn<Medico, String> colEspecialidad;

    @FXML
    private TableColumn<Medico, Boolean> colDisponibilidad;

    @FXML
    private Button btnCambiarDisponibilidad;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBack;

    private final ObservableList<Medico> listaMedico = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listaMedico.addAll(HospitalAppApplication.hospital.getMedicosHospital());
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colEspecialidad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEspecialidad()));
        colDisponibilidad.setCellValueFactory(data -> new javafx.beans.property.ReadOnlyObjectWrapper<>(data.getValue().isDisponible()));
        tablaMedicos.setItems(listaMedico);
    }

    @FXML
    private void onCambiarDisponibilidad(ActionEvent event) {
        // Lógica para cambiar la disponibilidad del médico
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));

        alert.showAndWait();
    }

    @FXML
    private void onActualizar(ActionEvent event) {
        // Lógica para actualizar la tabla
    }

    @FXML
    private void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Administrador.fxml", SceneManager.getAdministradorActual());
    }
}
