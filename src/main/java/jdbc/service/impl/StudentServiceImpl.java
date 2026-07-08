package jdbc.service.impl;

import jdbc.dto.StudentDTO;
import jdbc.entity.Student;
import jdbc.exception.DuplicateStudentException;
import jdbc.exception.StudentNotFoundException;
import jdbc.repository.StudentRepository;
import jdbc.repository.impl.StudentRepositoryImpl;
import jdbc.service.StudentService;
import jdbc.util.InputUtil;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private static final String STUDENT_NOT_FOUND="STUDENT NOT FOUND BY ID : ";
    private static final String STUDENT_ALREADY_EXISTS="STUDENT ALRADY EXISTS BY ID: ";

    public StudentServiceImpl(){
        this.studentRepository=new StudentRepositoryImpl();
    }


    @Override
    public void saveStudent(StudentDTO studentDTO) throws DuplicateStudentException {
        Student student=studentRepository.findStudent(studentDTO.getId());
        if(Objects.nonNull(student)){
            throw new DuplicateStudentException(STUDENT_ALREADY_EXISTS+student.getId());
        }else{
            studentRepository.saveStudent(InputUtil.convertStudentDtoToEntity(studentDTO));
        }
    }

    @Override
    public StudentDTO findStudent(int Id) throws StudentNotFoundException, DuplicateStudentException {
        Student student=studentRepository.findStudent(Id);
        if(Objects.isNull(student)){
            throw new DuplicateStudentException(STUDENT_NOT_FOUND+Id);
        }else{
            return InputUtil.convertStudentEntityToDto(student);
        }
    }

    @Override
    public void updateStudentDetails(int Id, String courseName) throws StudentNotFoundException, DuplicateStudentException {
        Student studentDTO=studentRepository.findStudent((Id));
        if(Objects.isNull(studentDTO)){
            throw new DuplicateStudentException(STUDENT_NOT_FOUND+Id);
        }else{
            studentRepository.updateStudentDetails(Id,courseName);
        }
    }

    @Override
    public void deleteStudent(int sId) throws StudentNotFoundException, DuplicateStudentException {
        Student studentDTO=studentRepository.findStudent(sId);
        if(Objects.isNull(studentDTO)){
            throw new StudentNotFoundException(STUDENT_NOT_FOUND + sId);
        }else{
            studentRepository.deleteStudent(sId);
        }

    }
}
