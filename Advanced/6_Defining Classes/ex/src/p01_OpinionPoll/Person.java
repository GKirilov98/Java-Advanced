package p01_OpinionPoll;

 class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getInfo(){
        return String.format("%s - %d", name, age);
    }
}
