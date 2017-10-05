package org.dador.paddingOracleClient;

import org.junit.Test;

import static org.dador.paddingOracleClient.HexConverters.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test for Hex string manipulation helpers.
 * Created by dame on 18/10/2016.
 */
public class HexConvertersTest {
    @Test
    public void should_get_printable_AAAdotA_for_414141_13_41() throws Exception {
        byte[] input = new byte[5];
        input[0] = 65;
        input[1] = 65;
        input[2] = 65;
        input[3] = 13;
        input[4] = 65;
        String expected = "AAA.A";
        assertEquals(expected, toPrintableString(input));
    }


    @Test
    public void should_convert_string_010A_to_1_10() throws Exception {
        String inputString = "010A";
        byte[] expected = new byte[2];
        expected[0] = 1;
        expected[1] = 10;
        byte[] result = toByteArrayFromHex(inputString);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_convert_array_1_10_to_string_010a() throws Exception {
        byte[] inputArray = new byte[2];
        inputArray[0] = 1;
        inputArray[1] = 10;
        String expected = "010a";

        String result = toHexFromByteArray(inputArray);
        assertEquals(expected, result);

    }

    @Test
    public void xorArray_should_return_array_of_0() throws Exception {
        byte[] input1 = toByteArrayFromHex("0101");
        byte[] input2 = toByteArrayFromHex("1212");
        byte[] expected = toByteArrayFromHex("1313");
        byte[] result = xorArray(input1, input2);
        assertArrayEquals(expected, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void xorArray_should_throw_exception() throws Exception {
        byte[] input1 = toByteArrayFromHex("0101");
        byte[] input2 = toByteArrayFromHex("12");
        xorArray(input1, input2);

    }
}