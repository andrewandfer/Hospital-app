package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;

    public Notificacion(String mensaje, LocalDateTime now) {
        this.mensaje = mensaje;
    }

    public void mostrar() {
        System.out.println(" Notificación: " + mensaje);
    }


}

