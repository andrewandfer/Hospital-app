package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CrearSalaFormViewController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private CheckBox checkDisponible;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private GestionarSalaHorariosViewController parentController;

    public void setParentController(GestionarSalaHorariosViewController controller) {
        this.parentController = controller;
    }

    @FXML
    void onGuardar(ActionEvent event) {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String capacidad = txtCapacidad.getText().trim();
        boolean disponible = checkDisponible.isSelected();

        if (id.isEmpty() || nombre.isEmpty() || capacidad.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }

        Sala nuevaSala = new Sala(id, nombre, capacidad, disponible);



        HospitalAppApplication.hospital.getSalas().add(nuevaSala);
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        mostrarAlerta("Sala guardada correctamente.");
        limpiarCampos();
        }


    @FXML
    void onCancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void mostrarAlerta(String mensaje, String titulo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCapacidad.clear();
        checkDisponible.setSelected(false);

    }
}

