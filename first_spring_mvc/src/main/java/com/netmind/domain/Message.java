package com.netmind.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Message {

    private Long id;
    private String mess;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (this.id != null && this.id > 0 && this.mess != null && this.mess.length() > 3) return true;
        else return false;
    }
}
