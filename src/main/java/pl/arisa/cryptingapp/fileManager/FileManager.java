package pl.arisa.cryptingapp.fileManager;

import java.io.*;
import java.util.Scanner;

public class FileManager implements IFileManager {
    private final String path;

    public FileManager(String path) {
        this.path = path;
    }

    @Override
    public String loadFromFile() {
        File file = new File(path);
        StringBuilder text = new StringBuilder();
        try {
            Scanner inputData = new Scanner(file);
            while(inputData.hasNext()) {
                text.append(inputData.nextLine());
            }
            inputData.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem z otwarciem pliku");
        }
        return text.toString().trim();
    }

    @Override
    public void saveToFile(String value) {
        try {
            FileWriter writer = new FileWriter(this.path, true);
            PrintWriter output = new PrintWriter(writer);
            output.println(value);
        } catch(IOException e) {
            System.out.println("Problem z zapisem do pliku");
        }
    }
}
