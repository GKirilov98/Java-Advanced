package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private int id = 0;
    private Map<Integer, Person> data;

    public Repository() {
        this.data = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void add(Person person) {
        this.id = data.size();
        while (true) {
            if (!this.data.containsKey(id)) {
                break;
            } else {
                this.id++;
            }
        }
        this.data.put(id, person);
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        boolean isContainsId = this.data.containsKey(id);
        if (isContainsId) {
            this.data.remove(id);
            this.data.put(id, newPerson);
        }

        return isContainsId;
    }

    public boolean delete(int id) {
        boolean isSuccess = this.data.containsKey(id);
        if (isSuccess) {
            this.data.remove(id);
        }

        return isSuccess;
    }

    public int getCount() {
        return this.data.size();
    }
}
