package controller;

import dao.CourseDAO;
import dao.GroupDAO;
import dao.ProfesorDAO;
import model.Course;
import model.Group;
import model.Profesor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CourseControllerTest {
    private CourseController courseController;
    private CourseDAO courseDAO;

    @BeforeEach
    void setUp() throws SQLException {
        //Mock de la conexion
        Connection mockConnection = Mockito.mock(Connection.class);

        //Simular el DAO
        courseDAO = Mockito.mock(CourseDAO.class);

        //Creamos la instancia de los nuevos objetos Mock
        courseController = new CourseController();
        courseController.courseDAO = courseDAO;

    }

    @Test
    void getCourses_fullList() throws SQLException {
        //Simulamos una lista
        List<Course> courses = Arrays.asList(
                new Course(4 ,"Matematicas" ,"Discreta" ,true),
                new Course( 5 ,"Ciencias" ,"Genetica"  ,true)
        );

        when(courseDAO.getCourse()).thenReturn(courses);

        //En esta seccion comparamos que lo que traigamos concida con la base del select
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Ejecutamos el metodo
        courseController.getCourse();

        //Verificamos si el meto al menos fue llamado
        verify(courseDAO, times(1)).getCourse();

        //Ver datos
        System.setOut(System.out);

        //Vericar que sean iguales
        String output = outContent.toString();
        assertTrue(output.contains("Id: 4 ,Nombre: Matematicas ,Descripción: Discreta ,Estatus: " + true ));
    }

    @Test
    void getCourses_sqlException() throws SQLException {
        // Simular excepción cuando se llama a getStudent()
        when(courseDAO.getCourse()).thenThrow(new SQLException("Database error"));

        // Capturar la salida del error
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        // Ejecutar el método
        courseController.getCourse();

        // Restaurar salida de error
        System.setErr(originalErr);

        // Verificar que se llamó al DAO
        verify(courseDAO, times(1)).getCourse();

        // Validar que se capturó el error en consola
        String output = errContent.toString();
        assertTrue(output.contains("java.sql.SQLException: Database error"));
    }

    @Test
    void addCourse_success() throws SQLException{
        //Simular la insercion de los datos
        doNothing().when(courseDAO).addCourse(any(Course.class));

        //Ahora ejecutamos
        courseController.addCourse("Nuevo Nombre", "Nuevo descripcion", true);

        //Vericamos que fue llamdo el metodo del DAO
        verify(courseDAO, times(1)).addCourse(any(Course.class));

    }

    @Test
    void addCourse_sqlException() throws SQLException {
        // Simular excepción cuando se llama a addStudent()
        doThrow(new SQLException("Insertion failed")).when(courseDAO).addCourse(any(Course.class));
//        when(studentDAO.addStudent(any(Student.class))).thenThrow(new SQLException("Insertion failed"));

        // Capturar la salida de error
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        // Ejecutar método
        courseController.addCourse("Nuevo", "Nueva Descripcion",  true);

        // Restaurar salida
        System.setErr(originalErr);

        // Verificar que se intentó insertar
        verify(courseDAO, times(1)).addCourse(any(Course.class));

        // Validar que la excepción fue impresa
        String output = errContent.toString();
        assertTrue(output.contains("java.sql.SQLException: Insertion failed"));
    }

    @Test
    void getCourseById_returnsStudent() throws SQLException{
        Course mockCourse= new Course(
                1, "Matematica", "Discreta", true
        );

        when(courseDAO.getCourseById(1)).thenReturn(mockCourse);

        Course result = courseController.getCourseById(1);

        assertTrue(result != null);
        assertTrue(result.getId() == 1);
        assertTrue(result.getName().equals("Matematica"));

        verify(courseDAO, times(1)).getCourseById(1);
    }

    @Test
    void getCourseById_returnsNull_whenSQLException() throws SQLException {
        // Arrange
        when(courseDAO.getCourseById(13)).thenThrow(new SQLException("Database error"));

        // Act
        Course result = courseController.getCourseById(13);

        // Assert
        assertTrue(result == null);
        verify(courseDAO, times(1)).getCourseById(13);
    }

    @Test
    void updateCourse_success() throws SQLException {
        // Arrange
        Course course = new Course(1, "Matematica", "Discreta", true);

        // Do nothing when updateStudent is called
        doNothing().when(courseDAO).updateCourse(course);

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        courseController.updateCourse(course);

        // Restore console
        System.setOut(originalOut);

        // Assert
        verify(courseDAO, times(1)).updateCourse(course);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Curso Actualizado con éxito"));
    }

    @Test
    void updateCourse_sqlException() throws SQLException {
        Course course = new Course(1, "Matematica", "Discreta", true);
        doThrow(new SQLException("DB error")).when(courseDAO).updateCourse(course);

        courseController.updateCourse(course);

        verify(courseDAO, times(1)).updateCourse(course);
    }

    @Test
    void deleteCourse_success() throws SQLException {
        // Arrange
        int profesorId = 1;

        doNothing().when(courseDAO).deleteCourse(profesorId);

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        courseController.deleteCourse(profesorId);

        // Restore console
        System.setOut(originalOut);

        // Assert
        verify(courseDAO, times(1)).deleteCourse(profesorId);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Curso fue eliminado con éxito"));
    }

    @Test
    void deleteCourse_sqlException() throws SQLException {
        int courseId = 1;

        doThrow(new SQLException("DB error")).when(courseDAO).deleteCourse(courseId);

        courseController.deleteCourse(courseId);

        verify(courseDAO, times(1)).deleteCourse(courseId);
    }
}
