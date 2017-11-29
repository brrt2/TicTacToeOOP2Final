package gamemanagement.locale;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LanguageFactoryTest {


    @Test
    public void testCreateLanguage() throws Exception {
        Language lang;
        assertEquals(lang=LanguageFactory.createLanguage("english.properties"),lang);
    }

}