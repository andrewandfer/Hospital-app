package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDateTime;
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


    public String solicitarCita(Paciente paciente, Medico medico, LocalDateTime fechaHora) {
        String error = validarDatosCita(paciente, medico, fechaHora);
        if (error != null) {
            throw new IllegalArgumentException(error);
        }
        String idCita = generarIdCita();
        Cita nuevaCita = new Cita(idCita, fechaHora, medico, paciente, Estado.PENDIENTE);
        programarCita(nuevaCita);
        return idCita;
    }


    public boolean cancelarCita(String idCita) {
        for(Cita cita: citas){
            if(cita.getIdCita().equals(idCita)){
                cita.setEstado(Estado.CANCELADA);
                System.out.println("Cita cancelada");
                return true;
            } else {
                System.out.println("No se encontró la cita con ID: " + idCita);
            }
        }
        return false;
    }


    public String validarDatosCita(Paciente paciente, Medico medico, LocalDateTime fechaHora) {
        if (paciente == null) {
            return "El paciente no puede ser nulo.";
        }
        if (medico == null) {
            return "El médico no puede ser nulo.";
        }
        if (fechaHora == null || fechaHora.isBefore(LocalDateTime.now())) {
            return "La fecha y hora de la cita deben ser futuras.";
        }

        return null; // Indica que los datos son válidos
    }

    public static String generarIdCita() {
        int id = (int) (Math.random() * 100000); // Genera un número entre 0 y 99999
        return String.format("%05d", id); // Asegura que siempre tenga 5 dígitos (rellena con ceros a la izquierda)
    }



    }






