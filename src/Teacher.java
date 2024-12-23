public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public int setYearsOfExperience() {
        return yearsOfExperience;
    }

    public void giveRaise(int percentage) {
        this.salary += (this.salary * percentage) / 100;
    }

    @Override
    public String toString() {
        return super.toString() +
                "I teach " + subject + ". My salary is " + salary + ".";
    }
}


