package _03Mankind;
public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker() {
    }

    public Worker(String firstName, String lastName,
                  double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);

    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.setLastName(lastName);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    private double getSalaryPerHour() {

        return this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append("Week Salary: ")
                .append(String
                        .format("%.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ")
                .append(String
                        .format("%.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ")
                .append(String
                        .format("%.2f", this.getSalaryPerHour()));

        return stringBuilder.toString();
    }
}