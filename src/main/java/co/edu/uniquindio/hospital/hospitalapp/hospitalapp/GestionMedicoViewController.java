package co.edu.uniquindio.hospital.hospitalapp.hospitalapp;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GestionMedicoViewController {

    @FXML
    private Button btnActualizarMedico;

    @FXML
    private Button btnEliminarMedico;

    @FXML
    private Button btnRegistrarMedico;

    @FXML
    private TableView<Medico> tablaMedicos;

    @FXML
    private TableColumn<Medico, String> tcApellido;

    @FXML
    private TableColumn<Medico, String> tcConsultorio;

    @FXML
    private TableColumn<Medico, String> tcEspecialidad;

    @FXML
    private TableColumn<Medico, String> tcId;

    @FXML
    private TableColumn<Medico, String> tcNombre;

    @FXML
    private TableColumn<Medico, String> tcNumLicencia;

    private final ObservableList<Medico> listaMedico = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tcId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        tcNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        tcApellido.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getApellido()));
        tcConsultorio.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getConsultorio()));
        tcEspecialidad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEspecialidad()));
        tcNumLicencia.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNumLicencia()));

        tablaMedicos.setItems(listaMedico);
    }

    @FXML
    void OnRegistrarMedico(ActionEvent event) {
        abrirFormularioMedico(false, null);
    }

    @FXML
    void OnActualizarMedico(ActionEvent event) {
        Medico medicoSeleccionado = tablaMedicos.getSelectionModel().getSelectedItem();

        if (medicoSeleccionado != null) {
            abrirFormularioMedico(true, medicoSeleccionado);
        } else {
            mostrarAlerta("Selección requerida", "Por favor seleccione un médico de la tabla.");
        }
    }

    @FXML
    void OnEliminarMedico(ActionEvent event) {
        Medico medicoSeleccionado = tablaMedicos.getSelectionModel().getSelectedItem();

        if (medicoSeleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar Médico");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Está seguro que desea eliminar al médico seleccionado?");
            Optional<ButtonType> resultado = confirmacion.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                listaMedico.remove(medicoSeleccionado);
            }
        } else {
            mostrarAlerta("Selección requerida", "Por favor seleccione un médico de la tabla.");
        }
    }

    private void abrirFormularioMedico(boolean editar, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/MedicoForm.fxml"));
            Parent root = loader.load();

            MedicoFormViewController controller = loader.getController();
            controller.setParentController(this);

            if (editar && medico != null) {
                controller.setModoEdicion(true, medico);
            }

            Stage stage = new Stage();
            stage.setTitle(editar ? "Actualizar Médico" : "Registrar Médico");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarMedicoATabla(Medico medico) {
        listaMedico.add(medico);
    }

    public void actualizarMedico(Medico original, Medico actualizado) {
        int indice = listaMedico.indexOf(original);
        if (indice >= 0) {
            listaMedico.set(indice, actualizado);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));
        alerta.showAndWait();
    }
}
