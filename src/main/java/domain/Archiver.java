package domain;

import java.security.NoSuchAlgorithmException;

public interface Archiver {
    void createArchive(String source, String dest) throws NoSuchAlgorithmException;

    String unArchive(String source, String dest);
}
