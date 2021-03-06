package pl.arisa.cryptingapp.crypter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCrypterTest {
    @Test
    public void shouldHaveProperCryptedResult() {
        String sentence = "Emancypacja kobiet miala swoj rozkwit w 1945";
        String expected = ". -- .- -. -.-. -.-- .--. .- -.-. .--- .-     -.- --- -... .. . -     -- .. .- .-.. .-     ... .-- --- .---     .-. --- --.. -.- .-- .. -     .--     .---- ----. ....- .....";

        ICrypter crypter = new MorseCrypter();
        assertEquals(expected, crypter.crypt(sentence));
    }

    @Test
    public void shouldHaveProperCryptedResult2() {
        String sentence = "Zygmunt Freud jest nazywany ojcem psychoanalizy";
        String expected = "--.. -.-- --. -- ..- -. -     ..-. .-. . ..- -..     .--- . ... -     -. .- --.. -.-- .-- .- -. -.--     --- .--- -.-. . --     .--. ... -.-- -.-. .... --- .- -. .- .-.. .. --.. -.--";

        ICrypter crypter = new MorseCrypter();
        assertEquals(expected, crypter.crypt(sentence));
    }
    @Test
    public void shouldHaveProperDecryptedResult() {
        String sentence = "--.. -.-- --. -- ..- -. -     ..-. .-. . ..- -..     .--- . ... -     -. .- --.. -.-- .-- .- -. -.--     --- .--- -.-. . --     .--. ... -.-- -.-. .... --- .- -. .- .-.. .. --.. -.--";
        String expected = "zygmunt freud jest nazywany ojcem psychoanalizy";

        ICrypter decrypter = new MorseCrypter();
        assertEquals(expected, decrypter.decrypt(sentence));
    }
    @Test
    public void shouldHaveProperDecryptedResult1() {
        String sentence = ". -- .- -. -.-. -.-- .--. .- -.-. .--- .-     -.- --- -... .. . -     -- .. .- .-.. .-     ... .-- --- .---     .-. --- --.. -.- .-- .. -     .--     .---- ----. ....- .....";
        String expected = "emancypacja kobiet miala swoj rozkwit w 1945";

        ICrypter decrypter = new MorseCrypter();
        assertEquals(expected, decrypter.decrypt(sentence));
    }

    @Test
    void encryptingAndDecryptingShouldWorkInBothSides() {
        ICrypter crypter = new MorseCrypter();
        String[] phrasesToTest = {"jakies zdanie o malej wartosci", "inny test zlozony z malych literek", "coskrotkiego", "ala ma kota", "coooooooooooooooooooooooooooooooosdluuuuuuuuuuuuuuuuuuuuuuugiegoooooooooo"};
        for(String phrase : phrasesToTest) {
            assertEquals(phrase, crypter.decrypt(crypter.crypt(phrase)));
        }
    }
}
