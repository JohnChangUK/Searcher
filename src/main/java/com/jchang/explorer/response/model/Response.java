package com.jchang.explorer.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Response<T> {

    private Integer code;
    private String message;
    private T result;

    private Response(Code code) {
        this.code = code.code;
        this.message = code.message;
    }

    public Response(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Response() {
        this.code = 0;
        this.message = "";
    }

    public static Response failed() {
        return new Response(Code.FAILURE);
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
