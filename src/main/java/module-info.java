module co.edu.uniquindio.hospital.hospitalapp.hospitalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model to javafx.base;

    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp to javafx.fxml;

    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp;
}
