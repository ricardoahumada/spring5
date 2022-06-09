package com.ricardo.services;

import com.ricardo.models.School;
import com.ricardo.models.Student;
import com.ricardo.persistence.SchoolsRepositoryInf;
import com.ricardo.persistence.StudentsRepositoryInf;

public class SchoolService implements SchoolServiceInf {
    private SchoolsRepositoryInf repoSchool;
    private StudentsRepositoryInf repoStudent;

    public void setRepo(SchoolsRepositoryInf repo) {
        this.repoSchool = repo;
    }

    public void setRepoStudent(StudentsRepositoryInf repo) {
        this.repoStudent = repo;
    }

    public School getSchoolById(Long id) {
        if (id > 0) return repoSchool.getById(id);
        else return null;
    }

    @Override
    public void addSchool(School school) {
        if (school.getName() != null) repoSchool.storeSchool(school);
    }

    @Override
    public void addSchoolAndFirstStudent(School school, Student student) {
        //repo estudiantes para añadir estudiante
        //repo escuela para añadir escuela
        if(student.isValid()){
            repoStudent.add(student);
            school.addStudent(student);
            repoSchool.storeSchool(school);
        }
    }
}
