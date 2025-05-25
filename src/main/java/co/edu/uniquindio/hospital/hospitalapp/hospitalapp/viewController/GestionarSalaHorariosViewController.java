package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Horario;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Sala;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class GestionarSalaHorariosViewController {

    @FXML
    private TableView<Sala> tablaSalas;

    @FXML
    private TableColumn<Sala, String> colNombreSala;

    @FXML
    private TableColumn<Sala, String> colUbicacion;

    @FXML
    private TableView<Horario> tablaHorarios;

    @FXML
    private TableColumn<Horario, String> colDia;

    @FXML
    private TableColumn<Horario, String> colHoraInicio;

    @FXML
    private TableColumn<Horario, String> colHoraFin;

    @FXML
    private Button btnAgregarSala;

    @FXML
    private Button btnEliminarSala;

    @FXML
    private Button btnAgregarHorario;

    @FXML
    private Button btnEliminarHorario;

    @FXML
    private Button btnBack;

    private ObservableList<Sala> listaSalas = FXCollections.observableArrayList();
    private ObservableList<Horario> listaHorarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Inicialización de columnas y vinculación de datos
    }

    @FXML
    private void onAgregarSala(ActionEvent event) {
        // Lógica para agregar una nueva sala
    }
    @FXML
    private void onActualizarSala(ActionEvent event) {

    }

    @FXML
    private void onEliminarSala(ActionEvent event) {
        // Lógica para eliminar una sala seleccionada
    }

    @FXML
    private void onAgregarHorario(ActionEvent event) {
        // Lógica para agregar un nuevo horario a una sala seleccionada
    }
    @FXML
    private void onActualizarHorario(ActionEvent event) {

    }
    @FXML
    private void onEliminarHorario(ActionEvent event) {
        // Lógica para eliminar un horario de una sala seleccionada
    }

    @FXML
    private void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Administrador.fxml", SceneManager.getAdministradorActual());
    }
}
