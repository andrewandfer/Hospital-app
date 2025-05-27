package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Medico extends Persona {

    private String especialidad;
    private String consultorio;
    private String numLicencia;
    private LinkedList<Horario> horarioMedico;
    private LinkedList<HistorialMedico> listaHistorialMedico;
    private Sala sala;
    private boolean disponible=true;
    private LinkedList<Paciente> pacientesAsignados;
    private LinkedList<Notificacion>notificacionessoobrecitas;

    public Medico(String nombre, String apellido, String id, String especialidad, String consultorio, String numLicencia, boolean disponible) {
        super(nombre, apellido, id);
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.numLicencia = numLicencia;
        this.disponible = disponible;
        this.horarioMedico = new LinkedList<>();
        this.listaHistorialMedico = new LinkedList<>();
        this.pacientesAsignados = new LinkedList<>();
        this.notificacionessoobrecitas = new LinkedList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public LinkedList<Horario> getHorarioMedico() {
        return horarioMedico;
    }

    public void setHorarioMedico(LinkedList<Horario> horarioMedico) {
        ;this.horarioMedico = horarioMedico;
    }

    public LinkedList<HistorialMedico> getListaHistorialMedico() {
        return listaHistorialMedico;
    }

    public void setListaHistorialMedico(LinkedList<HistorialMedico> listaHistorialMedico) {
        this.listaHistorialMedico = listaHistorialMedico;

    }

    public LinkedList<Notificacion> getNotificacionessoobrecitas() {
        return notificacionessoobrecitas;
    }

    public void setNotificacionessoobrecitas(LinkedList<Notificacion> notificacionessoobrecitas) {
        this.notificacionessoobrecitas = notificacionessoobrecitas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void agregarHorario(Horario horarioMedico) {
        this.horarioMedico.add(horarioMedico);
    }

    public void agregarHistorial(HistorialMedico historial) {
        this.listaHistorialMedico.add(historial);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void asignarPaciente(Paciente paciente) {
        if (pacientesAsignados == null) {
            pacientesAsignados = new LinkedList<>();
        }
        pacientesAsignados.add(paciente);
    }

    public LinkedList<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    public void setPacientesAsignados(LinkedList<Paciente> pacientesAsignados) {
        this.pacientesAsignados = pacientesAsignados;
    }

//    @Override
//    public String toString() {
//        return "Medico{" +
//                "especialidad='" + especialidad + '\'' +
//                ", consultorio='" + consultorio + '\'' +
//                ", numLicencia='" + numLicencia + '\'' +
//                ", horarioMedico=" + horarioMedico +
//                ", listaHistorialMedico=" + listaHistorialMedico +
//                ", sala=" + sala +
//                '}';
//    }

    @Override
    public String toString() {
        return getNombre() + ", Especialida: " + especialidad + ", Disponibilidad: " + (disponible ? "Disponible" : "No disponible");
    }


    public LinkedList<HistorialMedico> obtenerHistorialesPorPaciente(Paciente paciente) {
        LinkedList<HistorialMedico> historialesPaciente = new LinkedList<>();
        for (HistorialMedico historial : listaHistorialMedico) {
            if (historial.getPaciente().equals(paciente)) {
                historialesPaciente.add(historial);
            }
        }
        return historialesPaciente;
    }



    //metodo para registrar Diagnostico YTratamiento
    public void registrarDiagnosticoYTratamiento(String idHistorial, String diagnostico, String tratamiento, Paciente paciente) {
        HistorialMedico nuevoHistorial = new HistorialMedico(idHistorial, diagnostico, tratamiento, paciente);
        this.listaHistorialMedico.add(nuevoHistorial);
    }


    // metodo para elimimar el horarios de consulta
    public boolean eliminarHorarioConsulta(Horario horario) {
        return horarioMedico.remove(horario);  // Retorna true si se eliminó, false si no estaba
    }


    //metodo para obtener una lista de horarios
    public LinkedList<Horario> obtenerHorariosConsulta() {
        return horarioMedico;  // Devuelve la lista de horarios asignados
    }


    public boolean verificarHorarioExistente(Horario horario) {
        return horarioMedico.contains(horario);
    }


    // metodo para agregar un horario pero antes valida si el horario ya existe
    public boolean agregarHorarioConsulta(Horario nuevoHorario) {
        if (verificarHorarioExistente(nuevoHorario)) {
            return false;  // El horario ya existe no lo agregamos
        }
        horarioMedico.add(nuevoHorario);
        return true;
    }



    public String notificarCambioCita(Cita cita, Estado nuevoEstado, LocalDateTime nuevaFechaHora) {
        Estado estadoAnterior = cita.getEstado();
        LocalDateTime fechaAnterior = cita.getFechaHoraCita();

        // Actualizar estado y hora si aplica
        if (nuevaFechaHora != null) {
            cita.setFechaHoraCita(nuevaFechaHora);
        }

        cita.setEstado(nuevoEstado);

        // Generar mensaje
        String mensaje = "Notificación de cambio:\n" +
                "Paciente: " + cita.getPaciente().getNombre() + "\n" +
                "Cita ID: " + cita.getIdCita() + "\n" +
                "Estado anterior: " + estadoAnterior + "\n" +
                "Nuevo estado: " + nuevoEstado + "\n" +
                "Fecha anterior: " + fechaAnterior + "\n" +
                "Nueva fecha: " + cita.getFechaHoraCita();

        return mensaje;
    }




}
