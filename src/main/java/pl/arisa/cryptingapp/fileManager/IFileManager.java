package pl.arisa.cryptingapp.fileManager;

public interface IFileManager {
    String loadFromFile();
    void saveToFile(String value);
}
