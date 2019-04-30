package _03Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] studentArgs = bufferedReader.readLine()
                .split("\\s+");

        String studentFirstName = studentArgs[0];
        String studentLastName = studentArgs[1];
        String studentFacultyNumber = studentArgs[2];

        String[] workerArgs = bufferedReader.readLine()
                .split("\\s+");

        String workerFirstName = workerArgs[0];
        String workerLastName = workerArgs[1];
        double workerWeekSalary = Double.parseDouble(workerArgs[2]);
        double workerWorkHoursPerDay = Double.parseDouble(workerArgs[3]);

        try {
            Student student = new Student(studentFirstName,
                    studentLastName, studentFacultyNumber);

            System.out.println(student);
            System.out.println();

            Worker worker = new Worker(workerFirstName,
                    workerLastName, workerWeekSalary,
                    workerWorkHoursPerDay);

            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}