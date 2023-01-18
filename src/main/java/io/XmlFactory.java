package io;

import domain.DataSource;

public class XmlFactory implements Factory{
    @Override
    public DataSource createDataSource() {
        return new Xml();
    }
}
