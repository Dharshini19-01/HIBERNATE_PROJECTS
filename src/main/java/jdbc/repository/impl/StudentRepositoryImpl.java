package jdbc.repository.impl;

import jdbc.config.DataBaseConfig;
import jdbc.config.DataBaseConfig;
import jdbc.dto.StudentDTO;
import jdbc.entity.Student;
import jdbc.exception.DuplicateStudentException;
import jdbc.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static final SessionFactory sessionFactory = DataBaseConfig.getSessionFactory();


    @Override
    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student findStudent(int Id) throws DuplicateStudentException {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Student.class, Id);
        }
    }

    @Override
    public void updateStudentDetails(int Id, String courseName) throws DuplicateStudentException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.find(Student.class, Id);
            student.setCourse_name(courseName);
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteStudent(int sId) throws DuplicateStudentException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.find(Student.class, sId);
            session.remove(student);
            session.getTransaction().commit();
        }
    }
}

