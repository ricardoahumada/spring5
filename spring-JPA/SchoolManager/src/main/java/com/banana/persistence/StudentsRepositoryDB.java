package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Repository
@Profile("prod")
public class StudentsRepositoryDB implements StudentsRepositoryInf {

    @Value("${db.comm}")
    private String urlConn;

    private List<Student> students = new ArrayList<>();

    public StudentsRepositoryDB() {
        students.add(new Student(1L, "Ricardo db", "Ahumada", 1));
        students.add(new Student(2L, "Toni db", "Fdez", 2));
        students.add(new Student(3L, "David db", "Carcelen", 2));
        students.add(new Student(4L, "Ana db", "Roca", 4));
        students.add(new Student(5L, "Petra db", "Lopez", 3));
    }

    public void add(Student student) {
        this.students.add(student);
    }

    @Override
    public Student update(Student estudiante) {
        for (Student st : students) {
            if (st.getId() == estudiante.getId()) {
                st = estudiante;
                return st;
            }
        }
        return null;
    }

    public Student get(int idx) {
        return this.students.get(idx);
    }

    public Student getById(Long id) {
        for (Student st : students) {
            if (st.getId() == id) return st;
        }
        return null;
    }
}
