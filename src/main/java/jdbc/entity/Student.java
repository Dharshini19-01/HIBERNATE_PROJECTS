package jdbc.entity;

import jakarta.persistence.*;
import jdbc.enums.CourseType;
import jdbc.enums.Gender;
import jdbc.enums.Grades;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="student_tables")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @Column(name = "firstname",nullable = false)
    private String first_name;
    @Column(name = "lastname",nullable = false)
    private String last_name;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(name = "mobilenumber",nullable = false,unique = true,length = 10)
    private String mobile_number;
    @Column(name = "Emailid",nullable = false,unique = true)
    private String email_id;
    @Column(name = "courseid",nullable = false)
    private int course_id;
    @Column(name = "coursename",nullable = false)
    private String course_name;
    @Column(name = "enrolldate",nullable = false)
    private LocalDate enrollment_date;
    @Enumerated(value = EnumType.STRING)
    @Column(name="coursetype",nullable = false)
    private CourseType course_type;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Grades grade;

}
