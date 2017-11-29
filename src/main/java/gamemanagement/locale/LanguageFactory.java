package gamemanagement.locale;

public class LanguageFactory {
    public static Language createLanguage(String fileName) {
        return new Language(fileName);
    }
}