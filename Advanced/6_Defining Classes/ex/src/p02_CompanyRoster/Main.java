package p02_CompanyRoster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> allDepartments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            Employee employee;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary);
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        employee = new Employee(name, salary, tokens[4]);
                    } else {
                        employee = new Employee(name, salary, Integer.parseInt(tokens[4]));
                    }
                    break;
                default:
                    employee = new Employee(name, salary, tokens[4], Integer.parseInt(tokens[5]));
                    break;
            }

            String department = tokens[3];
            allDepartments.putIfAbsent(department, new Department(department));
            allDepartments.get(department).getEmployees().add(employee);
        }

        allDepartments.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().getAverage().compareTo(a.getValue().getAverage()))
                .findFirst()
                .stream()
                .forEach(e -> {
                    System.out.println("Highest Average Salary: " + e.getKey());
                    e.getValue()
                            .getEmployees()
                            .stream()
                            .sorted((a, b) -> Double.compare(b.getSalary(),a.getSalary()))
                            .forEach(em -> System.out.println(em.getInfo()));
                });
    }
}
