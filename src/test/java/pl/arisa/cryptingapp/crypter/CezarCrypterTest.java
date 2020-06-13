package pl.arisa.cryptingapp.crypter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CezarCrypterTest {

    @Test
    void cryptWithoutParametersShouldReturnCorrectly() {
        CezarCrypter cezarCrypter = new CezarCrypter();
        assertEquals("YHQL", cezarCrypter.crypt("VENI"));
    }

    @Test
    void cryptWithParametersShouldReturnCorrectly() {
        CezarCrypter cezarCrypter = new CezarCrypter();
        assertEquals("XYZK", cezarCrypter.crypt("VENI", 3, 12));
    }

    @Test
    void encryptedWithoutParametersShouldReturnCorrectly() {
        CezarCrypter cezarCrypter = new CezarCrypter();
        assertEquals("VENI", cezarCrypter.decrypt("YHQL"));
    }

    @Test
    void encryptedWithParametersShouldReturnCorrectly() {
        CezarCrypter cezarCrypter = new CezarCrypter();
        assertEquals("VENI", cezarCrypter.decrypt("XYZK", 3, 12));
    }

    @Test
    void encryptingAndDecryptingShouldWorkInBothSides() {
        ICrypter crypter = new CezarCrypter();
        String[] phrasesToTest = {"jakies zdanie o malej wartosci", "inny test zlozony z malych literek", "coskrotkiego", "ala ma kota", "coooooooooooooooooooooooooooooooosdluuuuuuuuuuuuuuuuuuuuuuugiegoooooooooo"};
        for(String phrase : phrasesToTest) {
            assertEquals(phrase, crypter.decrypt(crypter.crypt(phrase)));
        }
    }
}