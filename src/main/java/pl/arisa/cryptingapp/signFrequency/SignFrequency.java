package pl.arisa.cryptingapp.signFrequency;

public class SignFrequency {
    private int[] signFrequencyValues;
    private String input;

    public SignFrequency(String input) {
        signFrequencyValues = new int[28];
        this.input = input.trim().toLowerCase();
    }

    public int[] getSignFrequencyValues() {
        return this.signFrequencyValues;
    }

    public void countSigns() {
        String str = input.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            countCharacter(str.charAt(i));
        }
    }

    private void countCharacter(char character) {
        switch(character) {
            case ' ':
                break;
            case '-':
                signFrequencyValues[26]++;
                break;
            case '.':
                signFrequencyValues[27]++;
                break;
            default:
                signFrequencyValues[(int)character-97]++;
                break;
        }
    }

    private char getCharByCode(int code) {
        if(code >= 0 && code < 26) return (char)(code + 97);
        if(code == 26) return '-';
        if(code == 27) return '.';
        return ' ';
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < signFrequencyValues.length; i++) {
            char character = getCharByCode(i);
            if(signFrequencyValues[i] != 0)
                stringBuilder.append(character).append(": ").append(signFrequencyValues[i]).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
