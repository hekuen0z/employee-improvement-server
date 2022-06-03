package bsuir.diplom.serverapplication.utilities;

import bsuir.diplom.serverapplication.constants.Constants;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FilePropertyReader {
    private Properties p = null;

    public FilePropertyReader() {
        try {
            FileReader reader = new FileReader(Constants.FILE_PROPERTIES_PATH);
            p = new Properties();
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPropertyInt(String propertyName) {
        return Integer.parseInt(p.getProperty(propertyName));
    }

    public String getPropertyString(String propertyName) {
        return p.getProperty(propertyName);
    }
}
