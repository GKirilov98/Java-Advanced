package repository;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository
        Repository repository = new Repository();
        Repository repository1 = new Repository();

        //Initialize Person
        Person person = new Person("Pesho", 14, "13-07-2004");

        for (int i = 0; i < 100; i++) {
            repository.add(person);
        }

        System.out.println(repository.getId());
        System.out.println(repository1.getId());
    }
}
