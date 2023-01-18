package io;

import domain.DataSource;

public class TextFactory implements Factory{
    @Override
    public DataSource createDataSource(){
        return new Text();
    }
}
