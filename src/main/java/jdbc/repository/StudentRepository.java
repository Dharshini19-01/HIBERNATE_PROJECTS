package jdbc.repository;

import jdbc.dto.StudentDTO;
import jdbc.entity.Student;
import jdbc.exception.DuplicateStudentException;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student) throws DuplicateStudentException;
    Student findStudent(int Id) throws DuplicateStudentException;
    void updateStudentDetails(int Id, String courseName) throws DuplicateStudentException;
    void deleteStudent(int sId) throws DuplicateStudentException;
}
