package org.dador.paddingOracleClient;

import org.junit.Test;

import static org.dador.paddingOracleClient.HexConverters.getByteArrayFromStringHexRepresentation;
import static org.dador.paddingOracleClient.OraclePaddingClient.BLOCK_SIZE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the OraclePadding Decryption client
 * Created by dame on 18/10/2016.
 */
public class OraclePaddingClientTest {
    @Test
    public void should_buildGuessForPosition_return_() throws Exception {
        OraclePaddingClient opc = new OraclePaddingClient();
        byte[] cypher = getByteArrayFromStringHexRepresentation("02020202020202020202020202020202");
        byte[] decoded = getByteArrayFromStringHexRepresentation("00000000000000000000000000656565");
        byte guess = 1;
        int position = 12; // padding shoud be                   "00000000000000000000000004040404"
        byte[] expected = getByteArrayFromStringHexRepresentation("02020202020202020202020207636363");
        assertArrayEquals(expected, opc.buildGuessForPosition(cypher, decoded, position, guess));

    }

    @Test
    public void should_buildGuessForPosition_with_empty_valsreturn_() throws Exception {
        OraclePaddingClient opc = new OraclePaddingClient();

        byte[] cypher = new byte[BLOCK_SIZE];
        byte[] decoded = new byte[BLOCK_SIZE];
        byte guess = 2;
        int position = 15; // padding shoud be                   "00000000000000000000000004040404"
        byte[] expected = getByteArrayFromStringHexRepresentation("00000000000000000000000000000003");
        assertArrayEquals(expected, opc.buildGuessForPosition(cypher, decoded, position, guess));

    }


    @Test
    public void should_getPaddingArray__return_valid_padding_for_02() throws Exception {
        OraclePaddingClient opc = new OraclePaddingClient();

        byte[] expected = new byte[BLOCK_SIZE];
        expected[expected.length - 1] = (byte) 2;
        expected[expected.length - 2] = (byte) 2;
        byte[] result = opc.getPaddingArray(2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_getPaddingArray_return_full_block_for_padding_32() throws Exception {
        OraclePaddingClient opc = new OraclePaddingClient();

        byte[] expected = HexConverters.getByteArrayFromStringHexRepresentation("10101010101010101010101010101010");
        byte[] result = opc.getPaddingArray(16);
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_split_32ByteMsg_into_2_blocs() throws Exception {
        OraclePaddingClient opc = new OraclePaddingClient();

        String message = "0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF";
        byte[] hexMessage = getByteArrayFromStringHexRepresentation(message);
        byte[][] result = opc.splitMessageIntoBlocks(hexMessage);
        assertEquals(2, result.length);
        assertArrayEquals(getByteArrayFromStringHexRepresentation("0123456789ABCDEF0123456789ABCDEF"), result[0]);
    }

}