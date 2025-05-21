package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestionMedicoViewController implements ControladorConAdministrador{

    @FXML
    private Button btnActualizarMedico;

    @FXML
    private Button btnEliminarMedico;

    @FXML
    private Button btnRegistrarMedico;

    @FXML
    private Button btnBack;

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

    private Administrador administrador;

    @Override
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        cargarDatos();
    }
    @FXML
    public void initialize() {

        listaMedico.addAll(HospitalAppApplication.hospital.getMedicosHospital());

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
            controller.setParentController(this);  // para que pueda agregar a la tabla
            controller.setAdministrador(administrador); // PASAR administrador

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
        if (administrador != null) {
            administrador.getMedicosAdministrados().add(medico);
        }
    }

    public void actualizarMedico(Medico original, Medico actualizado) {
        int indice = listaMedico.indexOf(original);
        if (indice >= 0) {
            listaMedico.set(indice, actualizado);
            if (administrador != null) {
                administrador.getMedicosAdministrados().add(actualizado);
            }
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
    @FXML
    void OnBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/Administrador.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el administrador
            AdministradorViewController controller = loader.getController();
            controller.setAdministrador(this.administrador);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarMedicoSistema(Medico medico){
        HospitalAppApplication.hospital.agregarMedico(medico);
    }

    private void cargarDatos() {
        if (administrador != null) {
            List<Medico> medicosDisponibles = administrador.getMedicosAdministrados()
                    .stream()
                    .filter(Medico::isDisponible)
                    .collect(Collectors.toList());

            tablaMedicos.setItems(FXCollections.observableArrayList(medicosDisponibles));
        }
    }


}
