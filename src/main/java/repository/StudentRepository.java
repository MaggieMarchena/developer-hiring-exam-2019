package repository;

import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateSession;
import model.Student;

public class StudentRepository{

    public static List<Student> getAllStudents() {
        Session session = HibernateSession.getSessionFactory().openSession();
        String hql = "from Student s";
        List<Student> students = session.createQuery(hql).list();
        session.close();
        return students;
    }

    public static List<Student> getAllStudentsByLastName() {
        Session session = HibernateSession.getSessionFactory().openSession();
        String hql = "from Student s order by s.lastName";
        List<Student> students = session.createQuery(hql).list();
        session.close();
        return students;
    }
}
