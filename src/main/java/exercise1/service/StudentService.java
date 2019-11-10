package exercise1.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exercise1.model.Student;
import exercise1.repository.StudentRepository;

public class StudentService {
    public List<Student> getStudentsOrderByLastName(){
        return StudentRepository.getAllStudentsByLastName();
    }

    public Set<Long> getStudentsTakingASubject(final long subjectId) {
        return new HashSet<>(StudentRepository.getAllStudentsTakingASubject(subjectId));
    }
}
