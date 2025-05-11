package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GestionPacienteViewController {

    @FXML
    private Button btnActualizarPaciente;

    @FXML
    private Button btnBorrarPaciente;

    @FXML
    private Button btnRegistrarPaciente;

    @FXML
    private TableColumn<Paciente, String> tcApellido;

    @FXML
    private TableColumn<Paciente, String> tcId;

    @FXML
    private TableColumn<Paciente, String> tcNombre;

    @FXML
    private TableColumn<Paciente, LocalDate> tcFechaNacimiento;

    @FXML
    private TableView<Paciente> tablaPacientes;

    private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        tablaPacientes.setItems(listaPacientes);
    }

    @FXML
    void OnRegistrarPaciente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/PacienteForm.fxml"));
            Parent root = loader.load();

            PacienteFormViewController controller = loader.getController();
            controller.setParentController(this); // establecer el controlador padre

            Stage stage = new Stage();
            stage.setTitle("Registrar Paciente");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarPacienteATabla(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    @FXML
    void OnActualizarPaciente(ActionEvent event) {
        // implementación futura
    }

    @FXML
    void OnBorrarPaciente(ActionEvent event) {
        // implementación futura
    }
}
