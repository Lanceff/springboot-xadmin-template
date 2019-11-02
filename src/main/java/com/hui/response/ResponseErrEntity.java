package com.hui.response;

import com.hui.status.StatusCode;
import lombok.Data;

@Data
public class ResponseErrEntity {

    private String status;
    private int code;
    private String msg;

    public ResponseErrEntity() {
    }

    /*public ResponseEntity(T data, String status, int code) {
        this.data = data;
        this.status = status;
        this.code = code;
    }*/


    public ResponseErrEntity(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.code = statusCode.getCode();
    }
}
