package pl.arisa.cryptingapp.signFrequency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignFrequencyTest {
    @Test
    public void countedInStringShouldMatch() {
        String valueToCount = "abcdefghik";
        SignFrequency signFrequency = new SignFrequency(valueToCount);
        signFrequency.countSigns();
        String expectedString =
                "a: 1 (10%)\n" +
                "b: 1 (10%)\n" +
                "c: 1 (10%)\n" +
                "d: 1 (10%)\n" +
                "e: 1 (10%)\n" +
                "f: 1 (10%)\n" +
                "g: 1 (10%)\n" +
                "h: 1 (10%)\n" +
                "i: 1 (10%)\n" +
                "k: 1 (10%)";
        assertEquals(expectedString, signFrequency.toString());
    }
}

