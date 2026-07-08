package jdbc.service;

import jdbc.dto.StudentDTO;
import jdbc.entity.Student;
import jdbc.exception.DuplicateStudentException;
import jdbc.exception.StudentNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO student) throws DuplicateStudentException;
    StudentDTO findStudent(int Id) throws StudentNotFoundException, DuplicateStudentException;
    void updateStudentDetails(int Id, String courseName) throws StudentNotFoundException, DuplicateStudentException;
    void deleteStudent(int sId) throws StudentNotFoundException, DuplicateStudentException;

}
