package p01_Person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.trim().length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }

        this.name = name;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }

        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());

    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }
}
