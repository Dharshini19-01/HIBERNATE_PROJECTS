package jdbc.util;

import jdbc.dto.StudentDTO;
import jdbc.entity.Student;
import jdbc.enums.CourseType;
import jdbc.enums.Gender;
import jdbc.enums.Grades;
import lombok.Data;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
@Data
public class InputUtil {


    public static int acceptMenuOption(Scanner sc){
        System.out.println("1. Add a new students.");
        System.out.println("2. Fetch student details.");
        System.out.println("3. Update course details.");
        System.out.println("4. Delete student records.");
        System.out.print("ENTER THE CHOICE: ");
        int menuOption = sc.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 ) {
            return menuOption;
        } else {
            return acceptMenuOption(sc);
        }
    }

    public static StudentDTO acceptStudentDetailsToSave(Scanner sc){

        System.out.print("Enter id of student:");
        int id=sc.nextInt();
        System.out.print("Enter first name of student:");
        String first_name=sc.next();
        System.out.print("Enter last name of student:");
        String last_name=sc.next();
        System.out.print("Enter gender of student:" + Arrays.asList(Gender.values()));
        String gender= sc.next().toUpperCase();
        System.out.print("Enter city of student:");
        String city=sc.next();
        System.out.print("Enter state of student:");
        String state=sc.next();
        System.out.print("Enter mobile number of student:");
        String mobile_number=sc.next();
        System.out.print("Enter email id of student:");
        String email_id=sc.next();
        System.out.print("Enter id of course:");
        int course_id=sc.nextInt();
        System.out.print("Enter course name of student:");
        String course_name=sc.next();
        System.out.print("Enter enrollment date of student (dd-MM-yyyy):");
        String enrollment_date=sc.next();
        System.out.print("Enter course type of student:" + Arrays.asList(CourseType.values()));
        String course_type= sc.next().toUpperCase();
        System.out.print("Enter grade of student:" + Arrays.asList(Grades.values()));
        String grade= sc.next().toUpperCase();
        try {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(id);
            studentDTO.setFirst_name(first_name);
            studentDTO.setLast_name(last_name);
            studentDTO.setGender(Gender.valueOf(gender));
            studentDTO.setCity(city);
            studentDTO.setState(state);
            studentDTO.setMobile_number(mobile_number);
            studentDTO.setEmail_id(email_id);
            studentDTO.setCourse_id(course_id);
            studentDTO.setCourse_name(course_name);
            studentDTO.setEnrollment_date(convertStringToDate(enrollment_date));
            studentDTO.setCourse_type(CourseType.valueOf(course_type));
            studentDTO.setGrade(Grades.valueOf(grade));
            return studentDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return acceptStudentDetailsToSave(sc);
        }

    }

    public static StudentDTO convertStudentEntityToDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirst_name(student.getFirst_name());
        studentDTO.setLast_name(student.getLast_name());
        studentDTO.setGender(student.getGender());
        studentDTO.setCity(student.getCity());
        studentDTO.setState(student.getState());
        studentDTO.setMobile_number(student.getMobile_number());
        studentDTO.setEmail_id(student.getEmail_id());
        studentDTO.setCourse_id(student.getCourse_id());
        studentDTO.setCourse_name(student.getCourse_name());
        studentDTO.setEnrollment_date(student.getEnrollment_date());
        studentDTO.setCourse_type(student.getCourse_type());
        studentDTO.setGrade(student.getGrade());

        return studentDTO;
    }
    public static Student convertStudentDtoToEntity(StudentDTO studentDTO)  {
        Student student = new Student();

        student.setFirst_name(studentDTO.getFirst_name());
        student.setLast_name(studentDTO.getLast_name());
        student.setGender(studentDTO.getGender());
        student.setCity(studentDTO.getCity());
        student.setState(studentDTO.getState());
        student.setMobile_number(studentDTO.getMobile_number());
        student.setEmail_id(studentDTO.getEmail_id());
        student.setCourse_id(studentDTO.getCourse_id());
        student.setCourse_name(studentDTO.getCourse_name());
        student.setEnrollment_date(studentDTO.getEnrollment_date());
        student.setCourse_type(studentDTO.getCourse_type());
        student.setGrade(studentDTO.getGrade());
        return student;
    }

    public static LocalDate convertStringToDate(String stringDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(stringDate, format);
    }

    public static boolean wantToContinue(Scanner sc) {
        System.out.print("Press Y to continue and N to exit [Y/N] : ");
        char choice = sc.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static int acceptIdToOperate(Scanner sc) {
        System.out.print("Enter id of student:");
        return sc.nextInt();
    }

    public static String acceptStudentDetailsToUpdate(Scanner sc) {
        System.out.print("Enter NEW COURSE detail:");
        return sc.next();
    }
}
