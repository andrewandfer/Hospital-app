package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HistorialMedicoViewController {

    public Hospital hospital;


    @FXML
    private Button btnBack;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtTratamiento;

    @FXML
    void OnBack(ActionEvent event) {
        System.out.println("Volviendo atrás...");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Paciente.fxml", SceneManager.getAdministradorActual());
    }



    @FXML
    void OnPaciente() {
        System.out.println("Paciente: " + txtPaciente.getText());
    }

    @FXML
    void OnDiagnostico() {
        System.out.println("Diagnóstico: " + txtDiagnostico.getText());
    }

    @FXML
    void OnTratamiento() {
        System.out.println("Tratamiento: " + txtTratamiento.getText());
    }


    @FXML
    private Button btnBackConsultar;

    @FXML
    private Button buton_consultarHistorial;

    @FXML
    private TextField text_field_cedulaHistorial;

    @FXML
    void OnBackConsultar(ActionEvent event) {
        System.out.println("Volviendo atrás...");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "PacienteHistorialMedico.fxml", SceneManager.getAdministradorActual());
    }

    public void mostrarPaciente(Paciente paciente) {
        if (paciente != null) {
            txtPaciente.setText(paciente.getNombre());
            txtDiagnostico.setText(paciente.getHistorialMedico().getDiagnostico());
            txtTratamiento.setText(paciente.getHistorialMedico().getTratamiento());
        }
    }


    @FXML
    void onMostrarHistorial(ActionEvent event) {
        String cedula = text_field_cedulaHistorial.getText();
        Paciente paciente = hospital.buscarPaciente(cedula);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscenaConPaciente(stage, "HistorialMedicoForm.fxml", paciente);
    }




    @FXML
    public void initialize() {

        this.hospital = HospitalAppApplication.hospital;

    }



}

