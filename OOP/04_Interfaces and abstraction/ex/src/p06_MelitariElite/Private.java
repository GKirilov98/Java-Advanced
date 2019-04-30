package p06_MelitariElite;

public  class Private extends Soldier implements IPrivate{
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s Salary: %.2f",super.toString(), this.getSalary()));

        return sb.toString();
    }
}