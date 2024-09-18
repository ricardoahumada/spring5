package com.microcompany.productsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusMessage {

    private Integer status;
    private String message;

    public StatusMessage() {
    }

    public StatusMessage(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @JsonProperty(value = "status_code")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty(value = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StatusMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}