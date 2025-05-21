package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Paciente;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Administrador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AsignarPacienteMedicoViewController {

    @FXML
    private TableView<Medico> tablaMedicos;

    @FXML
    private TableColumn<Medico, String> colNombreMedico;

    @FXML
    private TableColumn<Medico, String> colEspecialidad;

    @FXML
    private TableColumn<Medico, Boolean> colDisponible;

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private TableColumn<Paciente, String> colNombrePaciente;

    @FXML
    private TableColumn<Paciente, String> colIdPaciente;

    @FXML
    private Button btnAsignar;

    private ObservableList<Medico> listaMedicos = FXCollections.observableArrayList();
    private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    private Administrador administrador;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        listaPacientes.setAll(administrador.getPacienteAdministrados());
    }



    @FXML
    public void initialize() {

        listaPacientes.addAll(HospitalAppApplication.hospital.getPacientes());
        listaMedicos.addAll(HospitalAppApplication.hospital.getMedicosHospital());


        colNombreMedico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        // Configurar columnas de pacientes
        colNombrePaciente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colIdPaciente.setCellValueFactory(new PropertyValueFactory<>("id"));

        tablaMedicos.setItems(listaMedicos);
        tablaPacientes.setItems(listaPacientes);

        // Habilitar botón solo si ambos están seleccionados
        btnAsignar.disableProperty().bind(
                tablaMedicos.getSelectionModel().selectedItemProperty().isNull()
                        .or(tablaPacientes.getSelectionModel().selectedItemProperty().isNull())
        );


        tablaPacientes.setItems(listaPacientes);
        tablaMedicos.setItems(listaMedicos);

    }

    private void cargarDatosDesdeAdministrador() {
        if (administrador != null) {
            listaMedicos.clear();
            listaPacientes.clear();

            // Cargar todos los médicos
            listaMedicos.addAll(administrador.getMedicosAdministrados());

            // Cargar pacientes sin médico asignado
            administrador.getPacienteAdministrados().stream()
                    .filter(paciente -> paciente.getMedicoAsignado() == null)
                    .forEach(listaPacientes::add);
        }
    }

    @FXML
    void onAsignar() {
        Medico medico = tablaMedicos.getSelectionModel().getSelectedItem();
        Paciente paciente = tablaPacientes.getSelectionModel().getSelectedItem();

        if (medico != null && paciente != null && medico.isDisponible()) {
            medico.asignarPaciente(paciente);
            paciente.setMedicoAsignado(medico);
            listaPacientes.remove(paciente);
            System.out.println("Paciente asignado con éxito");
        } else {
            System.out.println("Debe seleccionar un médico disponible y un paciente");
        }
    }
}
