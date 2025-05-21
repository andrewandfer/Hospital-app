package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Administrador administrador;

    public void setParentController(GestionMedicoViewController parentController) {
        this.parentController = parentController;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @FXML
    private void guardarMedico(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String consultorio = txtConsultorio.getText();
        String especialidad = txtEspecialidad.getText();
        String numLicencia = txtLicencia.getText();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || consultorio.isEmpty() || especialidad.isEmpty() || numLicencia.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos incompletos");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor complete todos los campos.");
            alerta.showAndWait();
            return;
        }
        Sala sala=new Sala("1","juan","112",true);
        Medico nuevoMedico = new Medico(id, nombre, apellido, consultorio, especialidad, numLicencia,sala,true);

        if (modoEdicion && medicoOriginal != null && parentController != null) {
            parentController.actualizarMedico(medicoOriginal, nuevoMedico);
        } else if (parentController != null) {
            parentController.agregarMedicoATabla(nuevoMedico);
        }

        Stage stage = (Stage) txtId.getScene().getWindow();
        stage.close();
    }

    private boolean modoEdicion = false;
    private Medico medicoOriginal = null;

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


    public void OnRegistrarMedico(ActionEvent actionEvent) {
    }
}
