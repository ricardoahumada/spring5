package com.banana.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    private Long id;
    private String name;

    private List<Student> estudiantes = new ArrayList<>();
}
