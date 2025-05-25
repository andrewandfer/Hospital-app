package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Horario;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;

public class GestionarSalaHorariosViewController {

    @FXML
    private Button btnActualizarHorario;

    @FXML
    private Button btnActualizarSala;

    @FXML
    private Button btnAgregarHorario;

    @FXML
    private Button btnAgregarSala;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEliminarHorario;

    @FXML
    private Button btnEliminarSala;

    @FXML
    private TableColumn<Horario, String> colDia;

    @FXML
    private TableColumn<Sala, Boolean> colDisponibilidad;

    @FXML
    private TableColumn<Horario, LocalTime> colHoraFin;

    @FXML
    private TableColumn<Horario, LocalTime> colHoraInicio;

    @FXML
    private TableColumn<Sala, String> colNombreSala;

    @FXML
    private TableColumn<Sala, String> colUbicacion;

    @FXML
    private TableView<Horario> tablaHorarios;

    @FXML
    private TableView<Sala> tablaSalas;
    private final ObservableList<Sala> listaSalas = FXCollections.observableArrayList();
    private final ObservableList<Horario> listaHorarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listaSalas.addAll(HospitalAppApplication.hospital.getSalas());
        tablaSalas.setItems(listaSalas);
        listaHorarios.addAll(HospitalAppApplication.hospital.getHorarioAtencion());
        tablaHorarios.setItems(listaHorarios);
        colNombreSala.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colUbicacion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdSala()));
        colDisponibilidad.setCellValueFactory(data -> new javafx.beans.property.SimpleBooleanProperty(data.getValue().getDisponibilidad()));
        colDia.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDia()));
        colHoraInicio.setCellValueFactory(data ->
                new javafx.beans.property.ReadOnlyObjectWrapper<LocalTime>(data.getValue().getHoraInicio()));
        colHoraFin.setCellValueFactory(data ->
                new javafx.beans.property.ReadOnlyObjectWrapper<LocalTime>(data.getValue().getHoraFin()));

}
    @FXML
    void onActualizarHorario(ActionEvent event) {

    }

    @FXML
    void onActualizarSala(ActionEvent event) {
        Sala salaSeleccionada = tablaSalas.getSelectionModel().getSelectedItem();

        if (salaSeleccionada != null) {
            salaSeleccionada.setDisponibilidad(!salaSeleccionada.isDisponible());
            tablaSalas.refresh();
        } else {
            mostrarAlerta("Error al cambiar la disponibilidad de la sala.", Alert.AlertType.ERROR);
        }

    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));

        alert.showAndWait();
    }

    @FXML
    void onAgregarHorario(ActionEvent event) {

    }

    @FXML
    void onAgregarSala(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/CrearSalaForm.fxml"));
            Parent root = loader.load();

            CrearSalaFormViewController controller = loader.getController();
            controller.setParentController(this);

            Stage stage = new Stage();
            stage.setTitle("Crear Sala");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Administrador.fxml", SceneManager.getAdministradorActual());
    }

    @FXML
    void onEliminarHorario(ActionEvent event) {
        Horario horarioSeleccionado = tablaHorarios.getSelectionModel().getSelectedItem();

        if (horarioSeleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar Horario");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Está seguro que desea eliminar el horario de atencion seleccionado?");
            Optional<ButtonType> resultado = confirmacion.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                listaHorarios.remove(horarioSeleccionado);
            }
        } else {
            mostrarAlerta("Selección requerida", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onEliminarSala(ActionEvent event) {
        Sala salaSeleccionada = tablaSalas.getSelectionModel().getSelectedItem();

        if (salaSeleccionada != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar sala");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Está seguro que desea eliminar la seleccionada de su lista de gestion?");
            Optional<ButtonType> resultado = confirmacion.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                listaSalas.remove(salaSeleccionada);
            }
        } else {
            mostrarAlerta("Selección requerida", Alert.AlertType.ERROR);
        }
    }
    public void registrarSala(Sala sala) {
        listaSalas.add(sala);
        tablaSalas.refresh();
    }
}

