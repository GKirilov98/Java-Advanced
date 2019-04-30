package p02_CompanyRoster;

import java.util.ArrayList;

 class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Double getAverage(){
      return this.employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }
}
