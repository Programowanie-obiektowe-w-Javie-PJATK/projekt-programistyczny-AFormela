package pl.arisa.cryptingapp.crypter;

public class CezarCrypter extends Crypter implements ICrypter {
    @Override
    public String crypt(String value) {
        return this.crypt(value, 1, 3);
    }

    @Override
    public String decrypt(String value) {
        return this.decrypt(value, 1, 3);
    }

    @Override
    public String crypt(String value, int a, int b) {
        if(a <= 0) throw new IllegalArgumentException("Parameter a should be positive (more than 0)!");
        if(b < 0) throw new IllegalArgumentException("Paramter b should be min 0");

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length(); i++) {
            result.append(cryptSign(value.charAt(i), a, b));
        }

        return result.toString();
    }

    @Override
    public String decrypt(String value, int a, int b) {
        if(a <= 0) throw new IllegalArgumentException("Parameter a should be positive (more than 0)!");
        if(b < 0) throw new IllegalArgumentException("Paramter b should be min 0");

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length(); i++) {
            result.append(decryptSign(value.charAt(i), a, b));
        }

        return result.toString();
    }

    private Character cryptSign(Character character, int a, int b) {
        if(character.equals(' ')) return ' ';
        else if((int)character < 'A' || (int)character > 'z') {
            throw new IllegalArgumentException("The sign to crypt is not a letter!");
        }
        else {
            int asciiOfA = getCodeFirstElement(character);
            return (char)(((((int)character - asciiOfA) * a + b) % 26)+asciiOfA);
        }
    }

    private Character decryptSign(Character character, int a, int b) {
        if(character.equals(' ')) return ' ';
        else if((int)character < 'A' || (int)character > 'z') {
            throw new IllegalArgumentException("The sign to decrypt is not a letter!");
        }
        else {
            int asciiOfA = getCodeFirstElement(character);
            int characterNumber = (int)character - asciiOfA;
            int diff = characterNumber - b;
            while(diff < 0 || diff % a != 0) diff += 26;
            return (char)(((diff/ a) % 26)+asciiOfA);
        }
    }

    private int getCodeFirstElement(char character) {
        return (int)character >= 97 ? 97 : 65;
    }
}
