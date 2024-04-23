package ucenfotec.ac.cr.dl;

import ucenfotec.ac.cr.util.Utils;

public class Conector {

    private static AccesoBD coneccionBD = null;

    public static AccesoBD getConnector(){

        String[] infoBD = Utils.getProperties();
        String URL = infoBD[0] = "//" + infoBD[1]+ "/"+infoBD[2];
        String user = infoBD[3];
        String password = infoBD[4];

        if(coneccionBD == null){
            coneccionBD = new AccesoBD(URL,user,password);
        }

        return coneccionBD;
    }

}
