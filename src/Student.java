import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int idCounter;
    private int studentID;
    private List<Integer> grades;

    public Student () {

    }
    public Student (String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >=0 && grade <=100) {
            grades.add(grade);
        } else {
            System.out.println("!!!between 0 and 100!!!");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty())
            return 0;
        int sum = 0;
        for (int grade: grades) {
            sum = sum + grade;
        }
        return (double) sum/ grades.size();
    }
    @Override
    public String toString() {
        return super.toString() +
                " I am a student with ID " + studentID + ".";
    }
}
