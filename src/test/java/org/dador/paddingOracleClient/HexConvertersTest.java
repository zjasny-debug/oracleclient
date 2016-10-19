package org.dador.paddingOracleClient;

import org.junit.Test;

import static org.dador.paddingOracleClient.HexConverters.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Hex string manipulation helpers.
 * Created by dame on 18/10/2016.
 */
public class HexConvertersTest {


    @Test
    public void should_convert_string_010A_to_1_10() throws Exception {
        String inputString = "010A";
        byte[] expected = new byte[2];
        expected[0] = 1;
        expected[1] = 10;
        byte[] result = getByteArrayFromStringHexRepresentation(inputString);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_convert_array_1_10_to_string_010a() throws Exception {
        byte[] inputArray = new byte[2];
        inputArray[0] = 1;
        inputArray[1] = 10;
        String expected = "010a";

        String result = getStringHexRepresentationFromByteArray(inputArray);
        assertEquals(expected, result);

    }

    @Test
    public void xorArray_should_return_array_of_0() throws Exception {
        byte[] input1 = getByteArrayFromStringHexRepresentation("0101");
        byte[] input2 = getByteArrayFromStringHexRepresentation("1212");
        byte[] expected = getByteArrayFromStringHexRepresentation("1313");
        byte[] result = xorArray(input1, input2);
        assertArrayEquals(expected, result);

    }


    @Test(expected = IllegalArgumentException.class)
    public void xorArray_should_throw_exception() throws Exception {
        byte[] input1 = getByteArrayFromStringHexRepresentation("0101");
        byte[] input2 = getByteArrayFromStringHexRepresentation("12");
        byte[] result = xorArray(input1, input2);

    }
}