package jdbc.dto;

import jdbc.enums.CourseType;
import jdbc.enums.Gender;
import jdbc.enums.Grades;
import lombok.Data;

import java.time.LocalDate;

@Data


public class StudentDTO {
    private int id;
    private String first_name;
    private String last_name;
    private Gender gender;
    private String city;
    private String state;
    private String mobile_number;
    private String email_id;
    private int course_id;
    private String course_name;
    private LocalDate enrollment_date;
    private CourseType course_type;
    private Grades grade;

}
