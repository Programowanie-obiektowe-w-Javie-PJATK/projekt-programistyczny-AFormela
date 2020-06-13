package pl.arisa.cryptingapp.fileManager;

import java.io.*;
import java.util.Scanner;

public class FileManager implements IFileManager {
    private File file;

    public FileManager(String path) {
        this.file = new File(path);
    }
    public FileManager(File file) { this.file = file; }

    @Override
    public String loadFromFile() {
        StringBuilder text = new StringBuilder();
        try {
            Scanner inputData = new Scanner(file);
            while(inputData.hasNext()) {
                text.append(inputData.nextLine());
            }
            inputData.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unexpected problem with opening file");
        }
        return text.toString().trim();
    }

    @Override
    public void saveToFile(String value) {
        try {
            FileWriter writer = new FileWriter(file.getPath(), true);
            PrintWriter output = new PrintWriter(writer);
            output.println(value);
            output.close();
        } catch(IOException e) {
            System.out.println("Unexpected problem with saving the file");
        }
    }
}
