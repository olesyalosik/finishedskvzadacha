package models;

import java.util.Objects;

public class Expression {
    private String data;

    private String result;

    public Expression(String data){
        this.data = data;
    }

    public Expression(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return data.equals(that.data) && result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, result);
    }
}
