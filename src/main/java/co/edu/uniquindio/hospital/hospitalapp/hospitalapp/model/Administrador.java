package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.LinkedList;

public class Administrador extends Persona {
    LinkedList<Horario> horariosCreados;
    LinkedList<Sala> salasAdministradas;
    LinkedList<Medico> medicosAdministrados;
    LinkedList<Paciente> PacienteAdministrados;
    LinkedList<Reporte> reportesAdministrados;


    public Administrador(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
        this.horariosCreados = new LinkedList<>();
        this.salasAdministradas = new LinkedList<>();
        this.medicosAdministrados = new LinkedList<>();
        this.PacienteAdministrados = new LinkedList<>();
        this.reportesAdministrados = new LinkedList<>();
    }

    public LinkedList<Reporte> getReportesAdministrados() {
        return reportesAdministrados;
    }

    public void setReportesAdministrados(LinkedList<Reporte> reportesAdministrados) {
        this.reportesAdministrados = reportesAdministrados;
    }

    public LinkedList<Horario> getHorariosCreados() {
        return horariosCreados;
    }

    public void setHorariosCreados(LinkedList<Horario> horariosCreados) {
        this.horariosCreados = horariosCreados;
    }

    public LinkedList<Sala> getSalasAdministradas() {
        return salasAdministradas;
    }

    public void setSalasAdministradas(LinkedList<Sala> salasAdministradas) {
        this.salasAdministradas = salasAdministradas;
    }

    public LinkedList<Medico> getMedicosAdministrados() {
        return medicosAdministrados;
    }

    public void setMedicosAdministrados(LinkedList<Medico> medicosAdministrados) {
        this.medicosAdministrados = medicosAdministrados;
    }

    public LinkedList<Paciente> getPacienteAdministrados() {
        return PacienteAdministrados;
    }

    public void setPacienteAdministrados(LinkedList<Paciente> pacienteAdministrados) {
        PacienteAdministrados = pacienteAdministrados;
    }
    public void eliminarPaciente(Paciente paciente) {
        PacienteAdministrados.remove(paciente);
    }
    public void agregarPaciente(Paciente paciente) {
        PacienteAdministrados.add(paciente);
    }
    public boolean actualizarPaciente(String idPaciente, HistorialMedico nuevoHistorial, LinkedList<Cita> nuevasCitas) {
        for (Paciente paciente : PacienteAdministrados) {
            if (paciente.getIdPaciente().equals(idPaciente)) {
                paciente.setHistorialMedico(nuevoHistorial);
                paciente.setCitas(nuevasCitas);
                return true;
            }
        }
        return false;
    }
    public void eliminarMedico(Medico medico) {
        medicosAdministrados.remove(medico);
    }
    public void agregarMedico(Medico medico) {
        medicosAdministrados.add(medico);
    }
    public boolean actualizarMedico(String numLicencia, String nuevaEspecialidad, String nuevoConsultorio,
                                    Sala nuevaSala, LinkedList<Horario> nuevoHorario,
                                    LinkedList<HistorialMedico> nuevoHistorial) {
        for (Medico medico : medicosAdministrados) {
            if (medico.getNumLicencia().equals(numLicencia)) {
                medico.setEspecialidad(nuevaEspecialidad);
                medico.setConsultorio(nuevoConsultorio);
                medico.setSala(nuevaSala);
                medico.setHorarioMedico(nuevoHorario);
                medico.setListaHistorialMedico(nuevoHistorial);
                return true;
            }
        }
        return false;
    }
    public boolean gestionarSalaPorId(String idSala) {
        for (Sala sala : salasAdministradas) {
            if (sala.getIdSala().equals(idSala)) {
                sala.setDisponibilidad(!sala.getDisponibilidad());
                return true;
            }
        }
        return false;
    }
    public boolean agregarHorarioAMedico(String idMedico, Horario nuevoHorario) {
        for (Medico medico : medicosAdministrados) {
            if (medico.getId().equals(idMedico)) {
                medico.agregarHorario(nuevoHorario);
                horariosCreados.add(nuevoHorario); // registrar también en el administrador
                return true;
            }
        }
        return false; // médico no encontrado
    }
    public boolean eliminarHorarioDeMedico(String idMedico, Horario horario) {
        for (Medico medico : medicosAdministrados) {
            if (medico.getId().equals(idMedico)) {
                if (medico.getHorarioMedico().remove(horario)) {
                    horariosCreados.remove(horario);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean modificarHorarioDeMedico(String idMedico, Horario horarioActual, Horario horarioNuevo) {
        for (Medico medico : medicosAdministrados) {
            LinkedList<Horario> horarios = medico.getHorarioMedico();
            int index = horarios.indexOf(horarioActual);
            if (index != -1) {
                horarios.set(index, horarioNuevo);
                // también actualizar en horariosCreados si es necesario
                int adminIndex = horariosCreados.indexOf(horarioActual);
                if (adminIndex != -1) {
                    horariosCreados.set(adminIndex, horarioNuevo);
                }
                return true;
            }
        }
        return false;
    }
    public void mostrarDisponibilidadMedicos() {
        System.out.println("Disponibilidad de Médicos:");
        for (Medico medico : medicosAdministrados) {
            String estado = medico.isDisponible() ? "Disponible" : "No disponible";
            System.out.println("- " + medico.getNombre() + " (" + medico.getEspecialidad() + "): " + estado);
        }
    }
    public boolean asignarPaciente(Paciente paciente) {
        for (Medico medico : medicosAdministrados) {
            if (medico.isDisponible()) {
                paciente.setMedicoAsignado(medico);
                medico.asignarPaciente(paciente);
                return true;
            }
        }
        return false;
    }
    public void generarReporteCitasPorEstado(Estado estadoBuscado) {
        StringBuilder reporte = new StringBuilder("=== Citas en estado: " + estadoBuscado + " ===\n");

        for (Paciente paciente : PacienteAdministrados) {
            for (Cita cita : paciente.getCitas()) {
                if (cita.getEstado() == estadoBuscado) {
                    reporte.append(cita).append("\n");
                }
            }
        }

        System.out.println(reporte);
    }






    @Override
    public String toString() {
        return "Administrador{" +
                "horariosCreados=" + horariosCreados +
                ", salasAdministradas=" + salasAdministradas +
                ", medicosAdministrados=" + medicosAdministrados +
                ", PacienteAdministrados=" + PacienteAdministrados +
                ", reportesAdministrados=" + reportesAdministrados +
                '}';
    }

}


