package com.sejenak.be_sejenakapp.vo;
public class Result {
    private int result;
    private String message;

    public Result(){}

    public Result(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
