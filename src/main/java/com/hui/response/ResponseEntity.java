package com.hui.response;

import com.hui.status.StatusCode;
import lombok.Data;

@Data
public class ResponseEntity<T> {

    private String status;
    private int code;
    private T data;

    public ResponseEntity() {
    }

    /*public ResponseEntity(T data, String status, int code) {
        this.data = data;
        this.status = status;
        this.code = code;
    }*/


    public ResponseEntity(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.code = statusCode.getCode();
    }

}
