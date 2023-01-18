package crypto;

import java.io.*;
public class Crypter {

    private static Crypter instance;

    private static final String key = ")J@NcRfUjXn2r5u8";

    private Crypter() {
    }

    public static Crypter getInstance() {
        if (instance == null) {
            return new Crypter();
        }
        return instance;
    }

    public void encrypt(String inputPath) {
        CryptoUtils.decrypt(key, new File(inputPath), new File(inputPath));
    }

    public void decrypt(String inputPath) {
        CryptoUtils.decrypt(key, new File(inputPath), new File(inputPath));
    }
}
