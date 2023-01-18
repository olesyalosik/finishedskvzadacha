package domain;


import models.Expression;

import java.util.List;

public interface DataSource {
    void writeData(List<Expression> data, String path);

    List<Expression> readData(String path);
}
