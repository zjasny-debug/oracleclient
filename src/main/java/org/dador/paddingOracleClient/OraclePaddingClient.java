package org.dador.paddingOracleClient;


/**
 *
 *
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
    protected static byte[] getPaddingArray(int n) {
        byte[] result = new byte[BLOCK_SIZE];

        /*
          TODO : YOUR CODE HERE
         */
        return result;
    }

    protected static byte[] applyDecodedToPadding(byte[] decoded) {
        byte[] result = new byte[BLOCK_SIZE];
        int decodedLenght = decoded.length;

        /*
          TODO : YOUR CODE HERE
         */
        return result;
    }

    /**
     * Fonction that splits a message into constituent blocs
     *
     * @param message
     * @return an array of blocs
     */
    protected static byte[][] splitMessageIntoBlocks(byte[] message) {
        byte[][] result = new byte[1][BLOCK_SIZE];

        /*
          TODO: YOUR CODE HERE
         */
        return result;
    }


    public static void main(String[] args) {
        PaddingOracleQuery opc = new PaddingOracleQuery();

        try {
            System.out.println("Server responded : " + opc.query(ENCRYPTED_MESSAGE));
        } catch (Exception e) {
            System.out.print("Exception caught. Server down ?");
            e.printStackTrace();
        }
    }

}

