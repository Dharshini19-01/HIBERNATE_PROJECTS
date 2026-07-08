package jdbc.main;

import jdbc.dto.StudentDTO;
import jdbc.service.StudentService;
import jdbc.service.impl.StudentServiceImpl;
import jdbc.util.InputUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app=new App();
        app.run();
    }

    public void run(){
        StudentService studentService=new StudentServiceImpl();
        try(Scanner sc=new Scanner(System.in)){
            do{
                int choice= InputUtil.acceptMenuOption(sc);
                switch(choice){
                    case 1:
                        System.out.println("Enter The Student Details");
                        StudentDTO studentDTO=InputUtil.acceptStudentDetailsToSave(sc);
                        studentService.saveStudent(studentDTO);
                        System.out.println("Student Saved Successfully");
                        break;
                    case 2:
                        int id=InputUtil.acceptIdToOperate(sc);
                        studentDTO=studentService.findStudent(id);
                        System.out.println(studentDTO);
                        break;
                    case 3:
                        int Id=InputUtil.acceptIdToOperate(sc);
                        String courseName=InputUtil.acceptStudentDetailsToUpdate(sc);
                        studentService.updateStudentDetails(Id,courseName);
                        System.out.println("Student Details updated Successfully ");
                        break;
                    case 4:
                        int sId=InputUtil.acceptIdToOperate(sc);
                        studentService.deleteStudent(sId);
                        System.out.println("Student Details Deleted Successfully");
                        break;

                }
            }while(InputUtil.wantToContinue(sc));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
