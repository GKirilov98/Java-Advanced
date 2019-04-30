package p07_Google;

public class Parents {
    private String name;
    private String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Parents() {
        this.name = "";
        this.birthday = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInfo(){
        if (name.isEmpty()){
            return "";
        } else {
            return "\n" + this.name + " " + this.birthday;
        }
    }
}
