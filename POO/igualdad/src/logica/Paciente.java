package logica;

public class Paciente extends Persona{

    private String fechaIngreso;
    private String doctor;

    public Paciente(String fechaIngreso, String doctor) {
        this.fechaIngreso = fechaIngreso;
        this.doctor = doctor;
    }

    public Paciente(String cedula, String nombre, String apellidos, String fechaIngreso, String doctor) {
        super(cedula, nombre, apellidos);
        this.fechaIngreso = fechaIngreso;
        this.doctor = doctor;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
