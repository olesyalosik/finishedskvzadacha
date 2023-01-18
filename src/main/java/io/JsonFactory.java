package io;

import domain.DataSource;

public class JsonFactory implements Factory{
    @Override
    public DataSource createDataSource(){
        return new Json();
    }
}
