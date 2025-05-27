package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Horario;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.time.LocalTime;


public class AdministrarHorarioMedicoViewController {

    @FXML
    private ComboBox<Medico> comboMedicos;
    @FXML
    private TableView<Horario> tablaHorarios;
    @FXML
    private TableColumn<Horario, String> colDia;
    @FXML
    private TableColumn<Horario, LocalTime> colHoraInicio;
    @FXML
    private TableColumn<Horario, LocalTime> colHoraFin;

    private ObservableList<Medico> medicos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Configura las columnas (ajusta los nombres de las propiedades según tu clase Horario)
        colDia.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDia()));
        colDia.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDia()));
        colHoraInicio.setCellValueFactory(data ->
                new javafx.beans.property.ReadOnlyObjectWrapper<LocalTime>(data.getValue().getHoraInicio()));
        colHoraFin.setCellValueFactory(data ->
                new javafx.beans.property.ReadOnlyObjectWrapper<LocalTime>(data.getValue().getHoraFin()));

        ObservableList<Medico> medicos = FXCollections.observableArrayList(
                HospitalAppApplication.hospital.getMedicosHospital()
        );
        comboMedicos.setItems(medicos);
        comboMedicos.setOnAction(event -> mostrarHorariosMedico());
    }

    public void setMedicos(java.util.List<Medico> listaMedicos) {
        medicos.setAll(listaMedicos);
    }

    private void mostrarHorariosMedico() {
        Medico medicoSeleccionado = comboMedicos.getValue();
        if (medicoSeleccionado != null && medicoSeleccionado.getHorariosAsignados() != null && !medicoSeleccionado.getHorariosAsignados().isEmpty()) {
            tablaHorarios.setItems(FXCollections.observableArrayList(medicoSeleccionado.getHorariosAsignados()));
        } else {
            tablaHorarios.setItems(FXCollections.observableArrayList());
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Sin horarios");
            alerta.setHeaderText(null);
            alerta.setContentText("El médico seleccionado no tiene horarios asignados o es un nuevo médico.");
            // Cambia el ícono de la ventana de la alerta
            Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo.png")));
            alerta.showAndWait();
        }
    }
    @FXML
    private void onBack(ActionEvent event) {
        // lógica para volver
    }

    public void onBack(javafx.event.ActionEvent actionEvent) {
    }
}



