package com.ricardo.persistence;

import com.ricardo.models.Student;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

//@Named
@Repository
public class StudentsRepository implements StudentsRepositoryInf {
    private List<Student> students = new ArrayList<>();

    public StudentsRepository() {
        students.add(new Student(1L, "Ricardo", "Ahumada", 1));
        students.add(new Student(2L, "Toni", "Fdez", 2));
        students.add(new Student(3L, "David", "Carcelen", 2));
        students.add(new Student(4L, "Ana", "Roca", 4));
        students.add(new Student(5L, "Petra", "Lopez", 3));
    }

    public void add(Student student) {
        Long newid = 0L;
        if (students.size() > 0) {
            Student ultimo = students.get(students.size() - 1);
            newid = ultimo.getId() + 1;
        } else {
            newid = 1L;
        }
        student.setId(newid);
        this.students.add(student);
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
