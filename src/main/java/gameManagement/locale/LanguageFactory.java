package gameManagement.locale;

public class LanguageFactory {
    public static Language createLanguage(String fileName) {
        return new Language(fileName);
    }
}