package org.dador.paddingOracleClient;

import org.junit.Test;

import static org.dador.paddingOracleClient.HexConverters.getByteArrayFromStringHexRepresentation;
import static org.dador.paddingOracleClient.OraclePaddingClient.BLOCK_SIZE;
import static org.dador.paddingOracleClient.OraclePaddingClient.splitMessageIntoBlocks;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dame on 18/10/2016.
 */
public class OraclePaddingClientTest {
    @Test
    public void getPaddingArray() throws Exception {

    }

    @Test
    public void should_return_valid_padding_for_02() throws Exception {
        byte[] expected = new byte[BLOCK_SIZE];
        expected[expected.length - 1] = (byte) 2;
        expected[expected.length - 2] = (byte) 2;
        byte[] result = OraclePaddingClient.getPaddingArray(2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_return_full_block_for_padding_32() throws Exception {
        byte[] expected = HexConverters.getByteArrayFromStringHexRepresentation("02020202020202020202020202020202");
        byte[] result = OraclePaddingClient.getPaddingArray(16);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_split_32ByteMsg_into_2_blocs() throws Exception {
        String message = "0123456789ABCDEF0123456789ABCDEF";
        byte[] hexMessage = getByteArrayFromStringHexRepresentation(message);
        byte[][] result = splitMessageIntoBlocks(hexMessage);
        assertEquals(2, result.length);
    }

}