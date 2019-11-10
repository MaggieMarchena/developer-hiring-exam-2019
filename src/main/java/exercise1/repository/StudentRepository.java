package exercise1.repository;

import java.util.List;

import org.hibernate.Session;

import exercise1.hibernate.HibernateSession;
import exercise1.model.Student;

public class StudentRepository{

    public static List<Long> getAllStudentsTakingASubject(long subjectId) {
        Session session = HibernateSession.getSessionFactory().openSession();
        String hql = "from student_subject ss where ss.subject_id = ?";
        List<Long> studentsIds = session.createQuery(hql)
                .setParameter(0, subjectId)
                .list();
        session.close();
        return studentsIds;
    }

    public static List<Student> getAllStudentsByLastName() {
        Session session = HibernateSession.getSessionFactory().openSession();
        String hql = "from Student s order by s.lastName";
        List<Student> students = session.createQuery(hql).list();
        session.close();
        return students;
    }
}
