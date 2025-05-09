module co.edu.uniquindio.hospital.hospitalapp.hospitalapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp to javafx.fxml;
    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp;
}