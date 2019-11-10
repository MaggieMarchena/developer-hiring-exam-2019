package service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Student;
import model.Subject;
import repository.StudentRepository;

public class StudentService {
    public List<Student> getStudentsOrderByLastName(){
        return StudentRepository.getAllStudentsByLastName();
    }

    public Set<Student> getStudentsTakingASubject(final Subject subject) {
        List<Student> students = StudentRepository.getAllStudents();
        return students.stream()
                .filter(student -> student.getEnrollments().contains(subject))
                .collect(Collectors.toSet());
    }
}
