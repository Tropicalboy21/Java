package cr.ac.ucenfotec.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Utils {
    public static String[] getProperties(){
        String[] properties = new String[5];
        Properties p = new Properties();
        String path = "src/cr/ac/ucenfotec/bd.properties";
        try {
            p.load(new FileInputStream(path));
            properties[0] = p.getProperty("driver");
            properties[1] = p.getProperty("server");
            properties[2] = p.getProperty("dataBase");
            properties[3] = p.getProperty("user");
            properties[4] = p.getProperty("password");
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}
