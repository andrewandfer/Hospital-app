package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

public class Sala {
    private String idSala;
    private String nombre;
    private String capacidad;
    private Boolean disponibilidad;

    public Sala(String idSala, String nombre, String capacidad, Boolean disponibilidad) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
    }

    public String getIdSala() {

        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala='" + idSala + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", especialidad=" + disponibilidad +
                '}';
    }
}
