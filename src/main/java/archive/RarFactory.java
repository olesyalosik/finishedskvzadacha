package archive;

import domain.Archiver;

public class RarFactory implements Factory{
    public Archiver createArchiver(){
        return new Rar();
    }
}
