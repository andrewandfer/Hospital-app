package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.Medico;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class MedicoRegistrarHistorialMedicoViewController {

    private Medico medico;

    public void setMedico(Medico medico) {
        this.medico = medico;
        // Aquí puedes cargar info relacionada al médico (nombre, especialidad, etc.)
    }


    @FXML
    private ChoiceBox<?> ChiceBoxPaciente;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtIdHistorialMedico;

    @FXML
    private TextField txtTratamiento;

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Medico.fxml", SceneManager.getAdministradorActual());

    }

    @FXML
    void OnRegistrar(ActionEvent event) {

    }

}
