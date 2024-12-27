import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        School school = new School();

        File studentFile = new File("C:\\Users\\асер\\IdeaProjects\\Assignment1\\students.txt");
        File teacherFile = new File("C:\\Users\\асер\\IdeaProjects\\Assignment1\\teachers.txt");

        Scanner studentScanner = new Scanner(studentFile);

        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine();
            try {
                String[] Data = line.split(" ");

                if (Data.length < 4) {
                    System.out.println("Invalid student data: " + line);
                    continue;
                }

                String name = Data[0];
                String surname = Data[1];
                int age = Integer.parseInt(Data[2]);
                boolean gender = Boolean.parseBoolean(Data[3]);

                Student student = new Student(name, surname, age, gender);

                for (int i = 4; i < Data.length; i++) {
                    student.addGrade(Integer.parseInt(Data[i]));
                }

                school.addMember(student);
            } catch (Exception error) {
                System.out.println("Error parsing student: " + line + " (" + error.getMessage() + ")");
            }
        }
        studentScanner.close();


        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNextLine()) {
            String line = teacherScanner.nextLine();
            try {
                String[] Data = line.split(" ");

                if (Data.length < 7) {
                    System.out.println("Invalid teacher data: " + line);
                    continue;
                }

                String name = Data[0];
                String surname = Data[1];
                int age = Integer.parseInt(Data[2]);
                boolean gender = Boolean.parseBoolean(Data[3]);
                String subject = Data[4];
                int yearsOfExperience = Integer.parseInt(Data[5]);
                int salary = Integer.parseInt(Data[6]);

                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);
            } catch (Exception error) {
                System.out.println("Error parsing teacher: " + line + " (" + error.getMessage() + ")");
            }
        }
        teacherScanner.close();


        System.out.println("School Members:");
        System.out.println(school);

        school.sortMembersBySurname();
        System.out.println("Sorted Members:");
        System.out.println(school);

        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student + " GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                    System.out.println(teacher + " New Salary: " + teacher.getSalary());
                } else {
                    System.out.println(teacher + " Salary remains: " + teacher.getSalary());
                }
            }
        }
    }
}