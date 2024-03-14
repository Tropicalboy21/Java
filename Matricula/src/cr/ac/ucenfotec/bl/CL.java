package cr.ac.ucenfotec.bl;

import java.time.LocalDate;
import java.util.ArrayList;

public class CL {

    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Curso> listaCursos;

    public CL(){
        listaCarreras = new ArrayList<>();
        listaCursos   = new ArrayList<>();
    }

    public String registrarCarrera(String codigo, String nombre, boolean esAcreditada){
        if(buscarCarrera(codigo) == null) {
            Carrera nuevaCarrera = new Carrera(codigo, nombre, esAcreditada);
            listaCarreras.add(nuevaCarrera);
            return "La carrera fue registrada correctamente!";
        }
        return "El código de la carrera ya existe en el sistema, ingrese otro!";
    }

    public ArrayList<String> listarCarreras(){
        ArrayList<String> infoCarreras = new ArrayList<>();
        for (Carrera carreraTemp:listaCarreras) {
            infoCarreras.add(carreraTemp.toString());
        }
        return infoCarreras;
    }

    public String registrarCurso(String codigo, String nombre, int creditos, double costo){
        Curso nuevoCurso = new Curso(codigo, nombre, creditos, costo);
        listaCursos.add(nuevoCurso);
        return "El curso fue registrada correctamente!";
    }

    public ArrayList<String> listarCursos(){
        ArrayList<String> infoCursos = new ArrayList<>();
        for (Curso cursoTemp:listaCursos) {
            infoCursos.add(cursoTemp.toString());
        }
        return infoCursos;
    }

    public String agregarCursoACarrera(String codigoCarrera, String codigoCurso){
        //1. Buscar la carrera
        //2. Si no la encuentra devolvemos mensaje de error
        //3. Si Sí la encuentra
        //4. Buscar el curso
        //5. Si no lo encuentra devolvemos mensaje de error
        //6. Aplicamos la AGREGACIÓN
        Carrera carrera = buscarCarrera(codigoCarrera);
        if(carrera != null){
            Curso curso = buscarCurso(codigoCurso);
             if(curso !=null){
                 // APLICAR AGREGACION
                 carrera.agregarCurso(curso);
                 return "El curso " + curso.getNombre() +" fue agregado a la carrera " + carrera.getNombre();
             }else
                 return "El curso con el código " +codigoCurso+", no existe en el sitema!";
        }else
            return "La carrera con el código " + codigoCarrera + ", no existe en el sistema!";
    }

    public Carrera buscarCarrera(String codigoCarrera){
        for (Carrera carreraEncotrada:listaCarreras) {
            if(carreraEncotrada.getCodigo().equals(codigoCarrera))
                return carreraEncotrada;
        }
        return null;
    }

    public Curso buscarCurso(String codigoCurso){
        for (Curso cursoEncontrado:listaCursos) {
            if(cursoEncontrado.getCodigo().equals(codigoCurso))
                return cursoEncontrado;
        }
        return null;
    }

    public String crearGrupoEnCurso(String codigoCurso, int numGrupo, String codigoGrupo){
        //1. Buscar Curso
        //2. Si no existe, devolvemos mensaje de error.
        //3. Si sí existe
        //4. Aplicamos COMPOSICIÓN
        Curso curso = buscarCurso(codigoCurso);
        if(curso != null){
            //Aplicamos COMPOSICIÓN
            curso.agregarGrupoACurso(numGrupo,codigoGrupo);
            return "El grupo " + codigoGrupo + ", fue creado dentro del curso " + curso.getNombre();
        }else
            return "El curso con el código " +codigoCurso+", no existe en el sitema!";
    }

    public String registrarProfesor(int identificacion, String nombre, LocalDate fechaNacimiento, String genero, String profesion){
        return "";
    }

}
