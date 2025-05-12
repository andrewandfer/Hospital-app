package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.ArrayList;
import java.util.List;

public class GestorCitas {

    private List<Cita> citas;
    private List<Notificacion> notificaciones;

    public GestorCitas() {
        this.citas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public void programarCita(Cita cita) {
        // Agregar la cita a la lista
        citas.add(cita);

        // Crear la notificación
        String mensaje = "Estimado/a " + cita.getPaciente().getNombre() +
                ", su cita fue programada para: " + cita.getFechaHoraCita();
        Notificacion notificacion = new Notificacion(mensaje);

        // Guardar la notificación sin mostrarla
        notificaciones.add(notificacion);
    }


    public void mostrarTodasLasNotificaciones() {
        for (Notificacion notificacion : notificaciones) {
            notificacion.mostrar(); // Se imprimen solo cuando el usuario lo decida
        }
        notificaciones.clear(); // Vacía la lista si ya se mostraron
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }
}




