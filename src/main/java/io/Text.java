package io;

import domain.DataSource;
import models.Expression;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Text implements DataSource {
    public void writeData(List<Expression> data, String path) {
        try {
            FileWriter file1txt = new FileWriter(path);
            BufferedWriter loggerTxt = new BufferedWriter(file1txt);
            for (Expression exp : data) {
                loggerTxt.write(exp.getResult());
                loggerTxt.newLine();
            }
            loggerTxt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Expression> readData(String path) {
        String tmp;
        List<Expression> result = new ArrayList<>();
        try {
            FileReader buf = new FileReader(path);
            BufferedReader fileIn = new BufferedReader(buf);
            while (true) {
                tmp = fileIn.readLine();
                if (tmp == null) {
                    break;
                }
                result.add(new Expression(tmp));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
