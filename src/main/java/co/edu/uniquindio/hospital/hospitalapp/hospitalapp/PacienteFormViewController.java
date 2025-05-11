package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class PacienteFormViewController {

    @FXML
    private DatePicker campoFecha;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    private GestionPacienteViewController parentController;

    public void setParentController(GestionPacienteViewController controller) {
        this.parentController = controller;
    }

    @FXML
    void OnRegistrarPaciente(ActionEvent event) {
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        LocalDate fechaNacimiento = campoFecha.getValue();

        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento == null) {
            System.out.println("Todos los campos son obligatorios.");
            return;
        }

        Paciente nuevoPaciente = new Paciente(cedula, nombre, apellido, fechaNacimiento, null);

        if (parentController != null) {
            parentController.agregarPacienteATabla(nuevoPaciente);
        }

        txtCedula.getScene().getWindow().hide(); // Cierra la ventana
    }
}





