package com.banana.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Student.findByIdx", query = "SELECT s FROM Student s WHERE s.nombre = :nombre ORDER BY s.id ASC")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surname")
    private String apellido;

    private int curso;

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
