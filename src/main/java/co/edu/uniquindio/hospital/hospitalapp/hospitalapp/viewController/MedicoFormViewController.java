package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MedicoFormViewController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtConsultorio;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtLicencia;

    private GestionMedicoViewController parentController;


    private boolean modoEdicion = false;
    private Medico medicoOriginal;

    public void setParentController(GestionMedicoViewController controller) {
        this.parentController = controller;
    }


    public void setModoEdicion(boolean modoEdicion, Medico medico) {
        this.modoEdicion = modoEdicion;
        this.medicoOriginal = medico;

        if (medico != null) {
            txtId.setText(medico.getId());
            txtNombre.setText(medico.getNombre());
            txtApellido.setText(medico.getApellido());
            txtConsultorio.setText(medico.getConsultorio());
            txtEspecialidad.setText(medico.getEspecialidad());
            txtLicencia.setText(medico.getNumLicencia());

            txtId.setDisable(true);
        }
    }

    @FXML
    void OnRegistrarMedico(ActionEvent event) {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String consultorio = txtConsultorio.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String licencia = txtLicencia.getText().trim();


        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() ||
                consultorio.isEmpty() || especialidad.isEmpty() || licencia.isEmpty()) {
            mostrarAlerta("Campos obligatorios", "Por favor complete todos los campos.");
            return;
        }
        Sala sala1=new Sala("162548","SALA PEDIATRIA","106",true);
        Medico nuevoMedico = new Medico(id, nombre, apellido, consultorio, especialidad, licencia,sala1 );

        if (parentController != null) {
            if (modoEdicion && medicoOriginal != null) {
                parentController.actualizarMedico(medicoOriginal, nuevoMedico);
            } else {
                parentController.agregarMedicoATabla(nuevoMedico);
            }
        }


        txtId.getScene().getWindow().hide();
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}


