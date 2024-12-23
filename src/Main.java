import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> members = new ArrayList<>();

        File studentFile = new File("C:\\Users\\асер\\IdeaProjects\\Assignment1\\students.txt");
        Scanner scanner = new Scanner(studentFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] studentData = line.split(" ");
            String name = studentData[0];
            String surname = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            boolean gender = Boolean.parseBoolean(studentData[3]);

            Student student = new Student(name, surname, age, gender);

            for (int i = 4; i < studentData.length; i++) {
                student.addGrade(Integer.parseInt(studentData[i]));
            }
            members.add(student);
        }

        File teacherFile = new File("C:\\Users\\асер\\IdeaProjects\\Assignment1\\teachers.txt");
        scanner = new Scanner(teacherFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] teacherData = line.split(" ");
            String name = teacherData[0];
            String surname = teacherData[1];
            int age = Integer.parseInt(teacherData[2]);
            boolean gender = Boolean.parseBoolean(teacherData[3]);
            String subject = teacherData[4];
            int yearsOfExperience = Integer.parseInt(teacherData[5]);
            int salary = Integer.parseInt(teacherData[6]);
            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            members.add(teacher);
        }

        for (Person person : members) {

            System.out.println(person.toString());

            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("GPA: " + student.calculateGPA());
            }

            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println("Before Raise: " + teacher.toString());

                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                    System.out.println("Updated Salary after 10% raise: " + teacher.toString());
                }
            }
        }

        scanner.close();
    }
}
