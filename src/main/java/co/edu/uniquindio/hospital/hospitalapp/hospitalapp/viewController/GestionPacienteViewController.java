package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GestionPacienteViewController {

    private Hospital hospital;

    @FXML
    private Button btnActualizarPaciente;

    @FXML
    private Button btnBorrarPaciente;

    @FXML
    private Button btnRegistrarPaciente;

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private TableColumn<Paciente, String> tcApellido;

    @FXML
    private TableColumn<Paciente, LocalDate> tcFechaNacimiento;

    @FXML
    private TableColumn<Paciente, String> tcId;

    @FXML
    private TableColumn<Paciente, String> tcNombre;

    private final ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listaPacientes.addAll(HospitalAppApplication.hospital.getPacientes());

        tcId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        tcNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        tcApellido.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getApellido()));
        tcFechaNacimiento.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getFechaNacimiento()));

        tablaPacientes.setItems(listaPacientes);
    }

    @FXML
    void OnRegistrarPaciente(ActionEvent event) {
        abrirFormularioPaciente(false, null);
    }

    public void agregarPacienteSistema(Paciente paciente){
        HospitalAppApplication.hospital.getPacientes().add(paciente);
        agregarPacienteATabla(paciente);
    }


    @FXML
    void OnActualizarPaciente(ActionEvent event) {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            abrirFormularioPaciente(true, seleccionado);
        } else {
            mostrarAlerta("Debes seleccionar un paciente para actualizar.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void OnBorrarPaciente(ActionEvent event) {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaPacientes.remove(seleccionado);
            HospitalAppApplication.hospital.getPacientes().remove(seleccionado);
        } else {
            mostrarAlerta("Debes seleccionar un paciente para eliminar.", Alert.AlertType.WARNING);
        }
    }

    public void agregarPacienteATabla(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public void actualizarPaciente(Paciente original, Paciente actualizado) {
        int index = listaPacientes.indexOf(original);
        if (index != -1) {
            listaPacientes.set(index, actualizado);
            HospitalAppApplication.hospital.getPacientes().set(index, actualizado);
        }
    }

    private void abrirFormularioPaciente(boolean editar, Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/PacienteForm.fxml"));
            Parent root = loader.load();

            PacienteFormViewController controller = loader.getController();
            controller.setParentController(this);

            if (editar && paciente != null) {
                controller.setModoEdicion(true, paciente);
            }

            Stage stage = new Stage();
            stage.setTitle(editar ? "Actualizar Paciente" : "Registrar Paciente");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Administrador.fxml", SceneManager.getAdministradorActual());

    }
}

