package archive;

import domain.Archiver;

public class ZipFactory implements Factory {
    public Archiver createArchiver(){
        return new Zip();
    }
}
