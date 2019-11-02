package com.hui.status;

public enum StatusCode {

    Success("成功", 200), Fail("失败", 300);

    private String status;
    private int code;

    StatusCode(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
