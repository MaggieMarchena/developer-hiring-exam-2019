package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Student;
import repository.StudentRepository;

public class StudentService {
    public List<Student> getStudentsOrderByLastName(){
        return StudentRepository.getAllStudentsByLastName();
    }

    public Set<Long> getStudentsTakingASubject(final long subjectId) {
        return new HashSet<>(StudentRepository.getAllStudentsTakingASubject(subjectId));
    }
}
