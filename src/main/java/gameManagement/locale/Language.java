package gameManagement.locale;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Language {

    private String askForFirstUserName;
    private String askForSecondUserName;


    private String askUserForBoardHeight;


    public Language(String languageSymbol) {
        String fileName=null;
        if(languageSymbol.equals("e"))  fileName="english.properties";
        else fileName="polish.properties";
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is =ClassLoader.getSystemResourceAsStream(fileName);
            // is = new FileInputStream("src/main/resources/" + fileName + ".properties");
            properties.load(is);
            askForFirstUserName=properties.getProperty("askForFirstUserName");
            askForSecondUserName=properties.getProperty("askForSecondUserName");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getAskForFirstUserName() {
        return askForFirstUserName;
    }

    public String getAskForSecondUserName() {
        return askForSecondUserName;
    }
}
