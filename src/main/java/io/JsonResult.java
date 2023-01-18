package io;

public class JsonResult {
    private String data;

    public JsonResult(){}

    public JsonResult(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
