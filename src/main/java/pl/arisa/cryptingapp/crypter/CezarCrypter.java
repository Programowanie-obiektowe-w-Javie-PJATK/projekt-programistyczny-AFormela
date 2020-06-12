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

    public String crypt(String value, int a, int b) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length(); i++) {
            result.append(cryptSign(value.charAt(i), a, b));
        }

        return result.toString();
    }

    public String decrypt(String value, int a, int b) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length(); i++) {
            result.append(decryptSign(value.charAt(i), a, b));
        }

        return result.toString();
    }

    private Character cryptSign(Character character, int a, int b) {
        if(character.equals(' ')) return ' ';
        else {
            int asciiOfA = (int)character >= 97 ? 97 : 65;
            return (char)(((((int)character - asciiOfA) * a + b) % 26)+asciiOfA);
        }
    }

    private Character decryptSign(Character character, int a, int b) {
        if(character.equals(' ')) return ' ';
        else {
            int asciiOfA = (int)character >= 97 ? 97 : 65;
            int characterAscii = (int)character - asciiOfA;
            int diff = characterAscii - b;
            while(diff < 0 || diff % a != 0) diff += 26;
            return (char)(((diff/ a) % 26)+asciiOfA);
        }
    }
}
