package pl.arisa.cryptingapp.crypter;

import pl.arisa.cryptingapp.fileManager.FileManager;
import pl.arisa.cryptingapp.signFrequency.SignFrequency;

public class Crypter implements ICrypter {
    @Override
    public String crypt(String value) {
        return null;
    }

    @Override
    public String crypt(String value, int a, int b) {
        return null;
    }

    @Override
    public String decrypt(String value) {
        return null;
    }

    @Override
    public String decrypt(String value, int a, int b) {
        return null;
    }

    @Override
    public String compareCryptedValues(String value1, String value2) {
        SignFrequency signFrequency1 = new SignFrequency(value1);
        signFrequency1.countSigns();
        SignFrequency signFrequency2 = new SignFrequency(value2);
        signFrequency2.countSigns();
        String result0 = value1.equals(value2) ? "Sentences are equal!" : "Sentences are not equal";
        String result1 = "First sentence contains (character: amount):\n" + signFrequency1.toString();
        String result2 = "Second sentence contains (character: amount):\n" + signFrequency2.toString();
        return result0 + '\n' + result1 + '\n' + result2;
    }

    public String decryptFromFile(String path) {
        FileManager fileManager = new FileManager(path);
        return this.decrypt(fileManager.loadFromFile());
    }

    public String cryptFromFile(String path) {
        FileManager fileManager = new FileManager(path);
        return this.crypt(fileManager.loadFromFile());
    }
}
