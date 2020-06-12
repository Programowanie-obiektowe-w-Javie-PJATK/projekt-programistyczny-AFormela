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
}
