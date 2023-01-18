package archive;

import com.github.junrar.Junrar;
import domain.Archiver;

import java.security.NoSuchAlgorithmException;

public class Rar implements Archiver {
    public void createArchive(String source, String dest) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("There is no open source rar algorithm!");
    }

    public String unArchive(String source, String dest){
        try {
            Junrar.extract(source, dest);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return dest;
    }
}
