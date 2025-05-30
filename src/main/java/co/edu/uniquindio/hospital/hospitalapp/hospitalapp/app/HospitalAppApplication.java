package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app;

import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model.*;
import co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController.HospitalAppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class   HospitalAppApplication extends Application {


    public static GestorCitas gestorCitas = new GestorCitas();

    public static Administrador admin = new Administrador("Carlos", "Gonzales", "0000");

    public static Hospital hospital = new Hospital("UQ", "Mi casa", "x", admin, gestorCitas);

    public static Medico medico = new Medico("Raul", "Gomez", "medico1", "nada", "D401",
            "000", true);


    public void cargarDatos() {

        Horario horario1= new Horario("lunes", LocalTime.of(8, 0), LocalTime.of(10, 0));
        Paciente pacientePrueba = new Paciente("Cristian", "Gonzalez", "123456789", LocalDate.of(2006, 07, 22));
        HistorialMedico historialMedicoPrueba = new HistorialMedico("Historial0", "Gripa", "Nada", pacientePrueba);
        Sala sala = new Sala("152","153","50",true);
        pacientePrueba.setHistorialMedico(historialMedicoPrueba);
        Cita cita1= new Cita("120364", LocalDateTime.of(2012,12,21,12,12),Estado.PENDIENTE);
        pacientePrueba.getCitas().add(cita1);
        hospital.getPacientes().add(pacientePrueba);
        medico.getCitasAsignadas().add(cita1);


        hospital.getMedicosHospital().add(medico);
        hospital.getHorarioAtencion().add(horario1);
        hospital.getSalas().add(sala);
    }

    @Override
    public void start(Stage stage) throws IOException {

        cargarDatos();
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalAppApplication.class.getResource("/co/edu/uniquindio/hospital/hospitalapp/hospitalapp/Hospitalapp-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        HospitalAppController controller = fxmlLoader.getController();
        controller.setMedico(medico);
        controller.setHospital(hospital);

        stage.getIcons().add(new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/imagenes/logo.png")
        )));

        stage.setTitle("HOSPITAL UQ");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
