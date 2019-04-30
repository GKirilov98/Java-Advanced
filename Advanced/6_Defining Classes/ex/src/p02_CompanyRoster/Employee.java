package p02_CompanyRoster;

 class Employee {
    public static final int AGE_CONSTANT_VALUE = -1;
    public static final String EMAIL_CONSTANT_VALUE = "n/a";
    //name, salary, position, department, email and age
    //name, salary, position, department
    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = EMAIL_CONSTANT_VALUE;
        this.age = AGE_CONSTANT_VALUE;
    }

    public Employee(String name, double salary, String email) {
       this(name, salary);
        this.email = email;
    }

    public Employee(String name, double salary, int age) {
        this(name, salary);
        this.age = age;
    }

    public Employee(String name, double salary, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.age = age;
    }

    public String getInfo(){
        return  String.format("%s %.2f %s %d", name, salary, email, age );
    }

    public Double getSalary(){
        return this.salary;
    }
}
