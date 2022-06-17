package com.netmind.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Message {


    private int id;
    private String mess;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", mess='" + mess + '\'' +
                '}';
    }

    public boolean isValid() {
        if (this.id > 0 && this.mess != null && this.mess.length() > 3) return true;
        else return false;
    }
}
