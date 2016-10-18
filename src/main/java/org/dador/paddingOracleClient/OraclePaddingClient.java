package org.dador.paddingOracleClient;


/**
 *
 *
 */
public class OraclePaddingClient {
    static final String ENCRYPTED_MESSAGE = "5ca00ff4c878d61e1edbf1700618fb287c21578c0580965dad57f70636ea402fa0017c4acc82717730565174e2e3f713d3921bab07cba15f3197b87976525ce4";


    public static void main(String[] args) {
        PaddingOracleQuery opc = new PaddingOracleQuery();

        try {
            System.out.println("Server responded : " + opc.query(ENCRYPTED_MESSAGE));
        } catch (Exception e) {
            System.out.print("Exception from server");
            e.printStackTrace();
        }
    }

}

