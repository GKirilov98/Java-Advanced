package p06_MelitariElite;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id>
        //Code Number: <codeNumber>

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Code Number: ").append(this.getCodeNumber());
        return sb.toString();
    }
}