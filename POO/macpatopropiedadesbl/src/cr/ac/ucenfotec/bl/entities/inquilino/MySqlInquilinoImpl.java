package cr.ac.ucenfotec.bl.entities.inquilino;

import cr.ac.ucenfotec.bl.entities.residencia.Residencia;
import cr.ac.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlInquilinoImpl implements IInquilinoDAO{
    private String sql;

    public String registrarInquilino(Inquilino inquilino) {
        sql="INSERT INTO INQUILINO(CEDULA,NOMBRE,PROFESION,EDAD) " +
                " VALUES("+inquilino.getCedula()+",'"+inquilino.getNombre()+"','"+inquilino.getProfesion()+"',"+inquilino.getEdad()+")";
        Conector.getConnector().ejecutarSQL(sql);

        return "El inquilino " + inquilino.getCedula() + ", se registro correctamente!";
    }

    public ArrayList<Inquilino> listarInquilinos() {
        ArrayList<Inquilino> listaInquilinos = new ArrayList<>();
        Inquilino inquilinoEncontrado;
        Residencia residenciaEncontrada;

        sql ="SELECT I.CEDULA, I.NOMBRE,I.PROFESION,I.EDAD,R.IDRESIDENCIA, \n" +
                "       R.PROVINCIA, R.CANTON, R.DISTRITO, R.BARRIO \n" +
                "FROM INQUILINO I LEFT JOIN RESIDENCIA R\n" +
                "ON I.IDRESIDENCIA = R.IDRESIDENCIA";
        try {
            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
            while(rs.next()){
                inquilinoEncontrado = new Inquilino(rs.getInt("CEDULA"),
                                                    rs.getString("NOMBRE"),
                                                    rs.getString("PROFESION"),
                                                    rs.getInt("EDAD"));
                if(rs.getInt("IDRESIDENCIA") >0){
                    residenciaEncontrada = new Residencia(rs.getInt("IDRESIDENCIA"),
                                                          rs.getString("PROVINCIA"),
                                                          rs.getString("CANTON"),
                                                          rs.getString("DISTRITO"),
                                                          rs.getString("BARRIO"));
                    inquilinoEncontrado.asignarResidencia(residenciaEncontrada);
                }
                listaInquilinos.add(inquilinoEncontrado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaInquilinos;
    }

    public String asignarResidencia(Inquilino inquilino, Residencia residencia) {
        sql="UPDATE INQUILINO SET IDRESIDENCIA="+residencia.getIdResidencia()+
            " WHERE CEDULA="+inquilino.getCedula();
        Conector.getConnector().ejecutarSQL(sql);

        return "La residencia N°" + residencia.getIdResidencia() +
                ", fue asignada al inquilino " + inquilino.getCedula();
    }
}
