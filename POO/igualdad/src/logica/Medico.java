package logica;

public class Medico extends Persona {
    private String numColegiado;
    private String especialidad;

    public Medico() {
    }

    public Medico(String cedula, String nombre, String apellidos, String numColegiado, String especialidad) {
        super(cedula, nombre, apellidos);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return
                "Medico{" +
                "numColegiado='" + numColegiado + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
