package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component("jdbcsr")
public class StudentsRepositoryJDBC implements StudentsRepositoryInf {

    private String urlConn;

    @Override
    public void add(Student estudiante) {

    }

    @Override
    public Student get(int idx) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public String getUrlConn() {
        return null;
    }
}
