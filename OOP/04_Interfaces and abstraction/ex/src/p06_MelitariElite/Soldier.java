package p06_MelitariElite;

public class Soldier implements ISoldier {
    private String id;
    private String firstName;
    private String lastName;

    public Soldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Name: <firstName> <lastName> Id: <id>
        //Code Number: <codeNumber>

        sb.append("Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append(" Id: ").append(this.getID());

        return sb.toString();
    }
}