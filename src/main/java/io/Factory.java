package io;

import domain.DataSource;

public interface Factory {
    DataSource createDataSource();
}
