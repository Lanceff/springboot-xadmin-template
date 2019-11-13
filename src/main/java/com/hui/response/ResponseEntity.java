package com.hui.response;

import com.hui.status.StatusCode;
import lombok.Data;

@Data
public class ResponseEntity {

    private String status;
    private int code;
    private String msg;
    private Object data;


    public ResponseEntity(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.code = statusCode.getCode();
    }

}
