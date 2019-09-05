package com.jchang.explorer.response.model;

public class Response<T> {

    private Integer code;
    private String message;
    private T result;

    public Response(Code code) {
        this.code = code.code;
        this.message = code.message;
    }

    public Response(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Response(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Response() {
        this.code = 0;
        this.message = "";
    }

    public static Response failed() {
        return new Response(Code.FAILURE);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public enum Code {
        SUCCESS(0, "SUCCESS"),
        FAILURE(1, "FAILURE");

        int code;
        String message;

        Code(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
