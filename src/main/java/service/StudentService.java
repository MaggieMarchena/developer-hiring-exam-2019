package service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Student;
import repository.StudentRepository;

public class StudentService {
    public List<Student> getStudentsOrderByLastName(){
        return StudentRepository.getAllStudentsByLastName();
    }

    public Set<Student> getStudentsTakingASubject(final String subject) {
        List<Student> students = StudentRepository.getAllStudents();
        return students.stream()
                .filter(student -> student.getEnrollments().contains(subject))
                .collect(Collectors.toSet());
    }
}
