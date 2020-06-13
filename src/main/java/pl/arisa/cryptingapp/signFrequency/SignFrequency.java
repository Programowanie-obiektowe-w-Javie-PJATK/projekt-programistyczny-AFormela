package pl.arisa.cryptingapp.signFrequency;

public class SignFrequency {
    private int[] signFrequencyValues;
    private String input;

    public SignFrequency(String input) {
        signFrequencyValues = new int[1000];
        this.input = input.trim().toLowerCase();
    }

    public int[] getSignFrequencyValues() {
        return this.signFrequencyValues;
    }

    public void countSigns() {
        String str = input.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ')
                signFrequencyValues[(int)str.charAt(i)]++;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < signFrequencyValues.length; i++) {
            char character = (char)(i);
            if(signFrequencyValues[i] != 0)
                result += character + ": " + signFrequencyValues[i] + " (" + (signFrequencyValues[i] * 100 / input.length()) + "%)\n";
        }
        return result.trim();
    }
}
