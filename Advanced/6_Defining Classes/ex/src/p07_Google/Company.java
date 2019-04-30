package p07_Google;

 class Company {
   private String name;
   private String department;
   private double salary;

  public Company() {
   this.name = "";
   this.department = "";
   this.salary = 0.0;
  }

  public Company(String name, String department, double salary) {
   this.name = name;
   this.department = department;
   this.salary = salary;
  }

  public String getName() {
   return name;
  }

  public void setName(String name) {
   this.name = name;
  }

  public String getDepartment() {
   return department;
  }

  public void setDepartment(String department) {
   this.department = department;
  }

  public double getSalary() {
   return salary;
  }

  public void setSalary(double salary) {
   this.salary = salary;
  }

  public String getInfo(){
   if (name.isEmpty()){
    return "";
   }

   return String.format("\n%s %s %.2f", name, department, salary);
  }
 }
