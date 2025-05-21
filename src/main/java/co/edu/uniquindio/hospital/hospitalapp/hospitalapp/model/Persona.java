package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDate;

public  abstract class  Persona {
    private String nombre;
    private String apellido;
    private String id;

    public Persona(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id='" + id ;
    }

    public void actualizarDatos(String nuevoNombre, String nuevoApellido, LocalDate nuevaFechaNacimiento) {
        if (nuevoNombre != null && !nuevoNombre.isBlank()) {
            setNombre(nuevoNombre);
        }
        if (nuevoApellido != null && !nuevoApellido.isBlank()) {
            setApellido(nuevoApellido);
        }
    }


    }

