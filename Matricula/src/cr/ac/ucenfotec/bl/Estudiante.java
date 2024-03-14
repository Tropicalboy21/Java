package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

public class Estudiante extends Persona {



    public Estudiante() {
    }

    public Estudiante(int identificacion, String nombre, LocalDate fechaNacimiento,
                      int edad, String genero) {
        super(identificacion, nombre, fechaNacimiento, edad, genero);
    }

    public String toString() {
        return super.toString();
    }
}
