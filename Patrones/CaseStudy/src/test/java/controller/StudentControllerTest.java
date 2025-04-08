package controller;

import dao.StudentDAO;
import model.ConnectionManager;
import model.Student;
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

public class StudentControllerTest {
    private StudentController studentController;
    private StudentDAO studentDAO;

    //Clase de JUnit
    @BeforeEach
    void setUp(){
        //Mock de la conexion
        Connection mockConnection = Mockito.mock(Connection.class);

        //Simular el DAO
        studentDAO = Mockito.mock(StudentDAO.class);

        //Creamos la instancia de los nuevos objetos Mock
        studentController = new StudentController();
        studentController.studentDAO = studentDAO;
    }

    @Test
    void getStudents_fullList() throws SQLException{
        //Simulamos una lista
        List<Student> students = Arrays.asList(
                new Student(13 ,"Daniel" ,"Gavilan" ,"604590182" ,"DD@aol.com", "01/18/2000", "BISOFT", true),
                new Student( 14 ,"Jose Mario" ,"Arias"  ,"114590172" ,"jm21@gmail.com", "11/03/98", "BISOFT", true)
        );

        when(studentDAO.getStudent()).thenReturn(students);

        //En esta seccion comparamos que lo que traigamos concida con la base del select
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Ejecutamos el metodo
        studentController.getStudent();

        //Verificamos si el meto al menos fue llamado
        verify(studentDAO, times(1)).getStudent();

        //Ver datos
        System.setOut(System.out);

        //Vericar que sean iguales
        String output = outContent.toString();
        assertTrue(output.contains("Id: 13 ,Nombre: Daniel ,Apellidos: Gavilan ,Identificación: 604590182 ,Email: DD@aol.com ,Fecha: 01/18/2000 ,Carrera: BISOFT" ));
    }

    @Test
    void getStudents_sqlException() throws SQLException {
        // Simular excepción cuando se llama a getStudent()
        when(studentDAO.getStudent()).thenThrow(new SQLException("Database error"));

        // Capturar la salida del error
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        // Ejecutar el método
        studentController.getStudent();

        // Restaurar salida de error
        System.setErr(originalErr);

        // Verificar que se llamó al DAO
        verify(studentDAO, times(1)).getStudent();

        // Validar que se capturó el error en consola
        String output = errContent.toString();
        assertTrue(output.contains("java.sql.SQLException: Database error"));
    }

    @Test
    void addStudent_success() throws SQLException{
        //Simular la insercion de los datos
        doNothing().when(studentDAO).addStudent(any(Student.class));

        //Ahora ejecutamos
        studentController.addStudent("Nuevo Nombre", "Nuevo Apellido", "nueva identificacion", "nuevo Email", "nueva fecha", "nueva carrera", true);

        //Vericamos que fue llamdo el metodo del DAO
        verify(studentDAO, times(1)).addStudent(any(Student.class));

    }

    @Test
    void addStudent_sqlException() throws SQLException {
        // Simular excepción cuando se llama a addStudent()
        doThrow(new SQLException("Insertion failed")).when(studentDAO).addStudent(any(Student.class));
//        when(studentDAO.addStudent(any(Student.class))).thenThrow(new SQLException("Insertion failed"));

        // Capturar la salida de error
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        // Ejecutar método
        studentController.addStudent("Nuevo", "Apellido", "123", "email@test.com", "01/01/2000", "BISOFT", true);

        // Restaurar salida
        System.setErr(originalErr);

        // Verificar que se intentó insertar
        verify(studentDAO, times(1)).addStudent(any(Student.class));

        // Validar que la excepción fue impresa
        String output = errContent.toString();
        assertTrue(output.contains("java.sql.SQLException: Insertion failed"));
    }

    @Test
    void getStudentById_returnsStudent() throws SQLException{
        Student mockStudent = new Student(
                13, "Daniel", "Gavilan", "604590182", "DD@aol.com", "01/18/2000", "BISOFT", true
        );

        when(studentDAO.getStudentById(13)).thenReturn(mockStudent);

        Student result = studentController.getStudentById(13);

        assertTrue(result != null);
        assertTrue(result.getId() == 13);
        assertTrue(result.getName().equals("Daniel"));

        verify(studentDAO, times(1)).getStudentById(13);
    }

    @Test
    void getStudentById_returnsNull_whenSQLException() throws SQLException {
        // Arrange
        when(studentDAO.getStudentById(13)).thenThrow(new SQLException("Database error"));

        // Act
        Student result = studentController.getStudentById(13);

        // Assert
        assertTrue(result == null);
        verify(studentDAO, times(1)).getStudentById(13);
    }

    @Test
    void updateStudent_success() throws SQLException {
        // Arrange
        Student student = new Student(1, "Juan", "Perez", "123456", "juan@gmail.com", "01/01/2000", "Software", true);

        // Do nothing when updateStudent is called
        doNothing().when(studentDAO).updateStudent(student);

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        studentController.updateStudent(student);

        // Restore console
        System.setOut(originalOut);

        // Assert
        verify(studentDAO, times(1)).updateStudent(student);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Estudiante Actualizado con éxito"));
    }

    @Test
    void updateStudent_sqlException() throws SQLException {
        Student student = new Student(1, "Juan", "Perez", "123456", "juan@gmail.com", "01/01/2000", "Software", true);
        doThrow(new SQLException("DB error")).when(studentDAO).updateStudent(student);

        studentController.updateStudent(student);

        verify(studentDAO, times(1)).updateStudent(student);
    }

    @Test
    void deleteStudent_success() throws SQLException {
        // Arrange
        int studentId = 1;

        doNothing().when(studentDAO).deleteStudent(studentId);

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        studentController.deleteStudent(studentId);

        // Restore console
        System.setOut(originalOut);

        // Assert
        verify(studentDAO, times(1)).deleteStudent(studentId);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Estudiante fue eliminado con éxito"));
    }

    @Test
    void deleteStudent_sqlException() throws SQLException {
        int studentId = 1;

        doThrow(new SQLException("DB error")).when(studentDAO).deleteStudent(studentId);

        studentController.deleteStudent(studentId);

        verify(studentDAO, times(1)).deleteStudent(studentId);
    }

}
