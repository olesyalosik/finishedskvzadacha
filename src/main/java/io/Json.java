package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.DataSource;
import models.Expression;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Json implements DataSource {

    private Gson gson;

    public Json() {
        this.gson = new Gson();//GsonBuilder().setPrettyPrinting().registerTypeAdapter(Expression.class, new Expression()).create();
    }


    public void writeData(List<Expression> data, String path) {
        List<JsonResult> results = new ArrayList<>();
        for (Expression ex : data) {
            results.add(new JsonResult(ex.getResult()));
        }
        String encoded = gson.toJson(results);
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(encoded);
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Expression> readData(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader(path);
            int c;
            while ((c = reader.read()) != -1) {

                sb.append((char) c);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Expression[] expArray = gson.fromJson(sb.toString(), Expression[].class);
        return Arrays.asList(expArray);
    }

}
