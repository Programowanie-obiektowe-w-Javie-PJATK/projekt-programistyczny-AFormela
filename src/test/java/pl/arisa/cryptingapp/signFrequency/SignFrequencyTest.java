package pl.arisa.cryptingapp.signFrequency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignFrequencyTest {
    @Test
    public void countedInStringShouldMatch() {
        String valueToCount = "abecadlo";
        StringBuilder expectedString = new StringBuilder();
        expectedString.append("a: 2\n");
        expectedString.append("b: 1\n");
        expectedString.append("c: 1\n");
        expectedString.append("d: 1\n");
        expectedString.append("e: 1\n");
        expectedString.append("l: 1\n");
        expectedString.append("o: 1");
        SignFrequency signFrequency = new SignFrequency(valueToCount);
        signFrequency.countSigns();
        assertEquals(expectedString.toString(), signFrequency.toString());
    }

    @Test
    public void countedValuesShouldMatch1() {
        String valueToCount = "jakies zdanie no nie wiem nie wiem";
        int[] expectedValues = {2, 0, 0, 1, 6, 0, 0, 0, 6, 1, 1, 0, 2, 4, 1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0};
        SignFrequency signFrequency = new SignFrequency(valueToCount);
        signFrequency.countSigns();

        for(int i = 0; i < signFrequency.getSignFrequencyValues().length; i++) {
            assertEquals(signFrequency.getSignFrequencyValues()[i], expectedValues[i]);
        }
    }
}