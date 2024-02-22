package util;

import java.io.FileInputStream;
import java.util.Properties;

public class LectorPropietats {

    Properties properties = new Properties();
    FileInputStream fitxerPropietats;
    private String entorn;
    private final String DIR_PROPIETATS = "src\\test\\resources\\";

    public LectorPropietats(String entorn){
        try {
            this.entorn = entorn;
            fitxerPropietats = new FileInputStream(DIR_PROPIETATS +"valors.properties");
            properties.load(fitxerPropietats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propietat){
        return properties.getProperty(entorn + "." + propietat);
    }
}
