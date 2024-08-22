package cl.praxis.ProyectoHospitalPost.model.dto;

public class Paciente {
    private int id;
    private String nombre;
    private boolean isHospitalized;

    public Paciente(String nombre, boolean isHospitalized) {
        this.nombre = nombre;
        this.isHospitalized = isHospitalized;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHospitalized() {
        return isHospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
        isHospitalized = hospitalized;
    }
}
