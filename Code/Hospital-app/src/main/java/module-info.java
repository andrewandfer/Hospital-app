module co.edu.uniquindio.hospital.hospitalapp.hospitalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model to javafx.base;
    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app to javafx.fxml;
    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app;


    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController;
    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp.viewController to javafx.fxml;

//    opens co.edu.uniquindio.hospital.hospitalapp.hospitalapp.controllers to javafx.fxml;
//    exports co.edu.uniquindio.hospital.hospitalapp.hospitalapp.hospitalapp.controllers;
}
