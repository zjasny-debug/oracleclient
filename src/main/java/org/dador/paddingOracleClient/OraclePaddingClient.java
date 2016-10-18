package org.dador.paddingOracleClient;


import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Main Class for Padding OracleClient
 */
public class OraclePaddingClient {
    static final String ENCRYPTED_MESSAGE = "5ca00ff4c878d61e1edbf1700618fb287c21578c0580965dad57f70636ea402fa0017c4acc82717730565174e2e3f713d3921bab07cba15f3197b87976525ce4";
    static final int BLOCK_SIZE = 16;

    /**
     * Fonction that create a block of 0 value, except for padding.
     *
     * @param n : number of bytes of padding
     * @return byte[BLOCK_SIZE] filled with 0 and padding values
     */
    protected byte[] getPaddingArray(int n) {
        byte[] result = new byte[BLOCK_SIZE];

        /**
         * TODO : Your CODE HERE
         */
        return result;
    }

    /**
     * Function that create a modified cyphertext bloc for trying a guess
     *
     * @param ciphertext : original ciphertext bloc
     * @param decoded    : decrypted part of the plain text (for next bloc)
     * @param position   : position of the byte to guess
     * @param guess      : the guess for this query
     * @return a byte array with c0...c(i-1)||ci+i+g||cj+mj+i||...||cn+mn+i
     */
    protected byte[] buildGuessForPosition(byte[] ciphertext, byte[] decoded, int position, byte guess) {
        byte[] result = new byte[BLOCK_SIZE];

        /**
         * TODO : YOUR CODE HERE
         */

        return result;
    }

    /**
     * Fonction that splits a message into constituent blocs
     *
     * @param message
     * @return an array of blocs
     */
    protected byte[][] splitMessageIntoBlocks(byte[] message) {
        if (message.length % BLOCK_SIZE != 0) {
            throw new IllegalArgumentException("Message length is not a multiple of bloc size");
        }
        /**
         * TODO : YOUR CODE HERE
         */
        return new byte[1][1];
    }

    public int getPaddingLengthForLastBlock(PaddingOracleQuery poq, byte[] previousbloc, byte[] lastbloc) throws IOException, URISyntaxException, IllegalAccessException {
        /**
         * TODO : Your Code HERE
         */
        // should not arrive here !
        return 0;
    }

    public byte[] runDecryptionForBlock(PaddingOracleQuery poq, byte[] iv, byte[] ciphertext, int padding) throws IOException, URISyntaxException {
        byte[] decoded = new byte[BLOCK_SIZE];
        if (padding > 0) {
            decoded = getPaddingArray(padding);
        }
        /**
         * TODO : YOUR CODE HERE
         */
        return decoded;
    }

    public static void main(String[] args) {
        OraclePaddingClient opc = new OraclePaddingClient();
        PaddingOracleQuery opq = new PaddingOracleQuery();
        try {
            System.out.println("Server responded : " + opq.query(ENCRYPTED_MESSAGE));
        } catch (Exception e) {
            System.out.print("Exception caught. Server down ?");
            e.printStackTrace();
        }
        try {
            /**
             * TODO : YOUR CODE HERE
             */
        } catch (Exception e) {
            System.out.print("Exception caught. Server down ?");
            e.printStackTrace();
        }
    }

}

