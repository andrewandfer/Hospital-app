package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.LinkedList;
import java.util.List;


public class MedicoRegistrarHistorialMedicoViewController {

    private Medico medico;

    public void setMedico(Medico medico) {
        this.medico = medico;
        // Aquí puedes cargar info relacionada al médico (nombre, especialidad, etc.)
    }


    @FXML
    private ChoiceBox<Paciente> ChiceBoxPaciente;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtIdHistorialMedico;

    @FXML
    private TextField txtTratamiento;
    private final ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();



    @FXML
    public void initialize() {
        listaPacientes.addAll(HospitalAppApplication.hospital.getPacientes());

        ChiceBoxPaciente.setItems(listaPacientes);


    }


    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Medico.fxml", SceneManager.getAdministradorActual());

    }

    @FXML
    void OnRegistrar(ActionEvent event) {

    }

}
