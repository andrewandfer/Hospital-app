package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

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

    private boolean modoEdicion = false;
    private Paciente pacienteOriginal;

    public void setParentController(GestionPacienteViewController controller) {
        this.parentController = controller;
    }

    public void setModoEdicion(boolean modoEdicion, Paciente paciente) {
        this.modoEdicion = modoEdicion;
        this.pacienteOriginal = paciente;

        if (paciente != null) {
            txtCedula.setText(paciente.getId());
            txtNombre.setText(paciente.getNombre());
            txtApellido.setText(paciente.getApellido());
            campoFecha.setValue(paciente.getFechaNacimiento());
            txtCedula.setDisable(true); // No permitir cambiar la cédula en edición
        }
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

        Paciente nuevoPaciente = new Paciente(cedula, nombre, apellido, fechaNacimiento);

        if (parentController != null) {
            if (modoEdicion && pacienteOriginal != null) {
                parentController.actualizarPaciente(pacienteOriginal, nuevoPaciente);
            } else {
                parentController.agregarPacienteATabla(nuevoPaciente);
            }
        }

        // Cierra la ventana
        txtCedula.getScene().getWindow().hide();
    }
}






