package com.banana.models;

import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ScienceProject extends Project{
    String subject;

    public ScienceProject(Long id, String name, List<Student> estudiantes, String subject) {
        super(id, name, estudiantes);
        this.subject = subject;
    }
}
