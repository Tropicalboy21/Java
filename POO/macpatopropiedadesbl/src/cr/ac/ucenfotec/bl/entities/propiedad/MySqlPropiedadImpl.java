package cr.ac.ucenfotec.bl.entities.propiedad;

import cr.ac.ucenfotec.bl.entities.hipoteca.Hipoteca;
import cr.ac.ucenfotec.bl.entities.inquilino.Inquilino;
import cr.ac.ucenfotec.bl.entities.residencia.Residencia;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPropiedadImpl implements IPropiedadDAO{

    private String sql;

    public String registrarPropiedad(Propiedad propiedad) {
        sql="INSERT INTO PROPIEDAD VALUES("+propiedad.getNumFinca()+",'"+ propiedad.getNombre()+
            "',"+propiedad.getCuartos()+",'"+propiedad.getProvincia()+"',"+ propiedad.getCostoMensual()+")";
        Conector.getConnector().ejecutarSQL(sql);

        return "La propiedad " + propiedad.getNombre() + ", fue resgistrada correctamente!";
    }

    public ArrayList<Propiedad> listarPropiedades() {
        ArrayList<Propiedad> listaPropiedades = new ArrayList<>();
        Propiedad propiedadEncontada;
        Inquilino inquilinoEncontado;

        sql = "SELECT NUMFINCA,NOMBRE,CUARTOS,PROVINCIA,COSTO FROM PROPIEDAD";

        try {
            ResultSet rsPropiedad = Conector.getConnector().ejecutarQuery(sql);
            while(rsPropiedad.next()){
                propiedadEncontada = new Propiedad(rsPropiedad.getInt("NUMFINCA"),
                                                    rsPropiedad.getString("NOMBRE"),
                                                    rsPropiedad.getInt("CUARTOS"),
                                                    rsPropiedad.getString("PROVINCIA"),
                                                    rsPropiedad.getDouble("COSTO"));

                sql="SELECT I.CEDULA, I.NOMBRE, I.PROFESION, I.EDAD\n" +
                        "FROM PROPIEDAD_INQUILINO PI INNER JOIN INQUILINO I\n" +
                        "ON  PI.CEDULA = I.CEDULA\n" +
                        "AND PI.NUMFINCA =" + propiedadEncontada.getNumFinca();
                ResultSet rsInquilino = Conector.getConnector().ejecutarQuery(sql);

                while(rsInquilino.next()){
                    inquilinoEncontado = new Inquilino(rsInquilino.getInt("CEDULA"),
                                                       rsInquilino.getString("NOMBRE"),
                                                       rsInquilino.getString("PROFESION"),
                                                       rsInquilino.getInt("EDAD"));
                    propiedadEncontada.agregarInquilino(inquilinoEncontado);
                }

                sql = "SELECT NUMHIPOTECA, FECHA, MONTO, ACREDOR FROM HIPOTECA WHERE NUMFINCA="+propiedadEncontada.getNumFinca();
                ResultSet rsHipotecas = Conector.getConnector().ejecutarQuery(sql);
                while(rsHipotecas.next()){
                    propiedadEncontada.asignarHipoteca(rsHipotecas.getInt("NUMHIPOTECA"),
                                                       rsHipotecas.getDate("FECHA").toLocalDate(),
                                                       rsHipotecas.getDouble("MONTO"),
                                                       rsHipotecas.getString("ACREDOR"));
                }
                listaPropiedades.add(propiedadEncontada);
            }

        }catch(Exception e){
           e.printStackTrace();
        }

        return listaPropiedades;
    }

    public String asignarInquilinoAPropiedad(Propiedad propiedad, Inquilino inquilino) {
        sql = "INSERT INTO PROPIEDAD_INQUILINO VALUES ("+inquilino.getCedula()+","+propiedad.getNumFinca()+")";
        Conector.getConnector().ejecutarSQL(sql);

        return "El inquilino "+ inquilino.getCedula() +", fue asignado a la propiedad " + propiedad.getNombre();
    }

    public String crearHipoteca(Propiedad propiedad, Hipoteca hipoteca) {
        sql = "INSERT INTO HIPOTECA VALUES("+hipoteca.getNumHipoteca()+",DATE('"+hipoteca.getFechaFinaliza()+
                                          "'),"+hipoteca.getMonto()+",'"+hipoteca.getAcredor()+"',"+propiedad.getNumFinca()+")";
        Conector.getConnector().ejecutarSQL(sql);

        return "Se crea de manera correcta la hipoteca N°" + hipoteca.getNumHipoteca() + ", para la propiedad "+propiedad.getNombre();
    }
}
