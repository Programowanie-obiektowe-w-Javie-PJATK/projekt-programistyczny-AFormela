package pl.arisa.cryptingapp.crypter;

public interface ICrypter {
    String crypt(String value);
    String crypt(String value, int a, int b);
    String decrypt(String value);
    String decrypt(String value, int a, int b);
    String compareCryptedValues(String value1, String value2);
    String decryptFromFile(String path);
    String cryptFromFile(String path);
}
