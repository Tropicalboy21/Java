package controller;

import dao.GroupDAO;
import dao.ProfesorDAO;
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

public class ProfesorControllerTest {
    private GroupController groupController;
    private GroupDAO groupDAO;

    @BeforeEach
    void setUp() throws SQLException {
        //Mock de la conexion
        Connection mockConnection = Mockito.mock(Connection.class);

        //Simular el DAO
        groupDAO = Mockito.mock(GroupDAO.class);

        //Creamos la instancia de los nuevos objetos Mock
        groupController = new GroupController();
        groupController.groupDAO = groupDAO;
    }

    @Test
    void getGroups_fullList() throws SQLException {
        //Simulamos una lista
        List<Group> groups = Arrays.asList(
                new Group(4 ,"Matematicas" ,"Discreta" ,true),
                    new Group( 5 ,"Ciencias" ,"Genetica"  ,true)
            );

            when(groupDAO.getGroup()).thenReturn(groups);

            //En esta seccion comparamos que lo que traigamos concida con la base del select
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            //Ejecutamos el metodo
            groupController.getGroup();

            //Verificamos si el meto al menos fue llamado
            verify(groupDAO, times(1)).getGroup();

            //Ver datos
            System.setOut(System.out);

            //Vericar que sean iguales
            String output = outContent.toString();
            assertTrue(output.contains("Id: 4 ,Nombre: Matematicas ,Descripción: Discreta ,Status: " + true ));
    }

        @Test
        void getGroup_sqlException() throws SQLException {
            // Simular excepción cuando se llama a getStudent()
            when(groupDAO.getGroup()).thenThrow(new SQLException("Database error"));

            // Capturar la salida del error
            ByteArrayOutputStream errContent = new ByteArrayOutputStream();
            PrintStream originalErr = System.err;
            System.setErr(new PrintStream(errContent));

            // Ejecutar el método
            groupController.getGroup();

            // Restaurar salida de error
            System.setErr(originalErr);

            // Verificar que se llamó al DAO
            verify(groupDAO, times(1)).getGroup();

            // Validar que se capturó el error en consola
            String output = errContent.toString();
            assertTrue(output.contains("java.sql.SQLException: Database error"));
        }

        @Test
        void addGroup_success() throws SQLException{
            //Simular la insercion de los datos
            doNothing().when(groupDAO).addGroup(any(Group.class));

            //Ahora ejecutamos
            groupController.addGroup("Nuevo Nombre", "Nuevo descripcion", true);

            //Vericamos que fue llamdo el metodo del DAO
            verify(groupDAO, times(1)).addGroup(any(Group.class));

        }

        @Test
        void addGroup_sqlException() throws SQLException {
            // Simular excepción cuando se llama a addStudent()
            doThrow(new SQLException("Insertion failed")).when(groupDAO).addGroup(any(Group.class));
//        when(studentDAO.addStudent(any(Student.class))).thenThrow(new SQLException("Insertion failed"));

            // Capturar la salida de error
            ByteArrayOutputStream errContent = new ByteArrayOutputStream();
            PrintStream originalErr = System.err;
            System.setErr(new PrintStream(errContent));

            // Ejecutar método
            groupController.addGroup("Nuevo", "Nueva Descripcion",  true);

            // Restaurar salida
            System.setErr(originalErr);

            // Verificar que se intentó insertar
            verify(groupDAO, times(1)).addGroup(any(Group.class));

            // Validar que la excepción fue impresa
            String output = errContent.toString();
            assertTrue(output.contains("java.sql.SQLException: Insertion failed"));
        }

        @Test
        void getGroupById_returnsStudent() throws SQLException{
            Group mockGroup = new Group(
                    1, "Matematica", "Discreta", true
            );

            when(groupDAO.getGroupById(13)).thenReturn(mockGroup);

            Group result = groupController.getGroupById(13);

            assertTrue(result != null);
            assertTrue(result.getId() == 13);
            assertTrue(result.getName().equals("Daniel"));

            verify(groupDAO, times(1)).getGroupById(13);
        }

        @Test
        void getGroupById_returnsNull_whenSQLException() throws SQLException {
            // Arrange
            when(groupDAO.getGroupById(13)).thenThrow(new SQLException("Database error"));

            // Act
            Group result
                    = groupController.getGroupById(13);

            // Assert
            assertTrue(result == null);
            verify(groupDAO, times(1)).getGroupById(13);
        }

        @Test
        void updateGroup_success() throws SQLException {
            // Arrange
            Group group = new Group(1, "Matematica", "Discreta", true);

            // Do nothing when updateStudent is called
            doNothing().when(groupDAO).updateGroup(group);

            // Capture output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Act
            groupController.updateGroup(group);

            // Restore console
            System.setOut(originalOut);

            // Assert
            verify(groupDAO, times(1)).updateGroup(group);
            String output = outContent.toString().trim();
            assertTrue(output.contains("Grupo Actualizado con éxito"));
        }

        @Test
        void updateGroup_sqlException() throws SQLException {
            Group group = new Group(1, "Matematica", "Discreta", true);
            doThrow(new SQLException("DB error")).when(groupDAO).updateGroup(group);

            groupController.updateGroup(group);

            verify(groupDAO, times(1)).updateGroup(group);
        }

        @Test
        void deleteGroup_success() throws SQLException {
            // Arrange
            int profesorId = 1;

            doNothing().when(groupDAO).deleteGroup(profesorId);

            // Capture console output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Act
            groupController.deleteGroup(profesorId);

            // Restore console
            System.setOut(originalOut);

            // Assert
            verify(groupDAO, times(1)).deleteGroup(profesorId);
            String output = outContent.toString().trim();
            assertTrue(output.contains("Group eliminado con éxito"));
        }

        @Test
        void deleteGroup_sqlException() throws SQLException {
            int profesorId = 1;

            doThrow(new SQLException("DB error")).when(groupDAO).deleteGroup(profesorId);

            groupController.deleteGroup(profesorId);

            verify(groupDAO, times(1)).deleteGroup(profesorId);
        }
    }

