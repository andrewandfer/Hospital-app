package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDate;

public class Reporte {
    private String idReporte;
    private String tipoReporte;
    private String contenidoReporte;
    private LocalDate fechaGeneracionReporte;

    public Reporte(String idReporte, String tipoReporte, String contenidoReporte, LocalDate fechaGeneracionReporte) {
        this.idReporte = idReporte;
        this.tipoReporte = tipoReporte;
        this.contenidoReporte = contenidoReporte;
        this.fechaGeneracionReporte = fechaGeneracionReporte;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getContenidoReporte() {
        return contenidoReporte;
    }

    public void setContenidoReporte(String contenidoReporte) {
        this.contenidoReporte = contenidoReporte;
    }

    public LocalDate getFechaGeneracionReporte() {
        return fechaGeneracionReporte;
    }

    public void setFechaGeneracionReporte(LocalDate fechaGeneracionReporte) {
        this.fechaGeneracionReporte = fechaGeneracionReporte;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "idReporte='" + idReporte + '\'' +
                ", tipoReporte='" + tipoReporte + '\'' +
                ", contenidoReporte='" + contenidoReporte + '\'' +
                ", fechaGeneracionReporte=" + fechaGeneracionReporte +
                '}';
    }
}

