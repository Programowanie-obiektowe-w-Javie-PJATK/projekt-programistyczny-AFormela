package pl.arisa.cryptingapp.crypter;

import java.util.HashMap;
import java.util.Map;

public class MorseCrypter extends Crypter {
    private final HashMap<Character, String> _morseAlphabet = new HashMap<Character, String>() {{
        put('a', ".-");
        put('b', "-...");
        put('c', "-.-.");
        put('d', "-..");
        put('e', ".");
        put('f', "..-.");
        put('g', "--.");
        put('h', "....");
        put('i', "..");
        put('j', ".---");
        put('k', "-.-");
        put(' ', "   ");
        put('l', ".-..");
        put('m', "--");
        put('n', "-.");
        put('o', "---");
        put('p', ".--.");
        put('r', ".-.");
        put('s', "...");
        put('t', "-");
        put('u', "..-");
        put('v', "...-");
        put('w', ".--");
        put('x', "-..-");
        put('y', "-.--");
        put('z', "--..");
        put('1', ".----");
        put('2', "..---");
        put('3', "...--");
        put('4', "....-");
        put('5', ".....");
        put('6', "-....");
        put('7', "--...");
        put('8', "---..");
        put('9', "----.");
        put('0', "-----");
    }};

    public String crypt(String value) {
        String str = value.toLowerCase();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            result.append(_morseAlphabet.get(str.charAt(i))).append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public String decrypt(String value) {
        String[] words = value.split("     ");
        StringBuilder result = new StringBuilder();
        for(String word : words) {
            String[] signs = word.split(" ");
            for(String sign : signs) {
                result.append(getKey(_morseAlphabet, sign));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
