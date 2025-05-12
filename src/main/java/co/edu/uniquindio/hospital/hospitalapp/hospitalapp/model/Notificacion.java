package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

public class Notificacion {
    private String mensaje;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrar() {
        System.out.println(" Notificación: " + mensaje);
    }


}

