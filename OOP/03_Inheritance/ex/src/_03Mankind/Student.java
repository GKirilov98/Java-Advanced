package _03Mankind;

public class Student extends Human {

    private String facultyNumber;

    public Student() {
    }

    public Student(String firstName, String lastName,
                   String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5
                || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append("Faculty number: ")
                .append(this.getFacultyNumber());

        return stringBuilder.toString();
    }
}