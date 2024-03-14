package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

public class Profesor extends Persona {

    private String profesion;

    public Profesor(){
    }

    public Profesor(int identificacion, String nombre, LocalDate fechaNacimiento,
                    int edad, String genero, String profesion) {
        super(identificacion, nombre, fechaNacimiento, edad, genero);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String toString() {
        return super.toString() + " ,profesion='" + profesion;
    }
}
