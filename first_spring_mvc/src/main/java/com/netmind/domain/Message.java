package com.netmind.domain;

public class Message {
    private String mess;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mess='" + mess + '\'' +
                '}';
    }
}
