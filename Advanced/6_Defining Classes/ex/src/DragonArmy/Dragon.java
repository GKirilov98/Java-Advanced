package DragonArmy;

class Dragon {
    private static int DEMAGE_DEF_VALUE = 45;
    private static int HEALTH_DEF_VALUE = 250;
    private static int ARMOR_DEF_VALUE = 10;

    public String getName() {
        return name;
    }

    public void setDemage(String demage) {
        if (tryParseInt(demage)) {
            this.demage = Integer.parseInt(demage);
        } else {
            this.demage = DEMAGE_DEF_VALUE;
        }

    }

    public void setHealth(String health) {
        if (tryParseInt(health)) {
            this.health = Integer.parseInt(health);
        } else {
            this.health = HEALTH_DEF_VALUE;
        }
    }

    public int getDemage() {
        return demage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        if (tryParseInt(armor)) {
            this.armor = Integer.parseInt(armor);
        } else {
            this.armor = ARMOR_DEF_VALUE;
        }
    }

    private String name = "";
    private int demage;
    private int health;
    private int armor;

    public Dragon(String name, String demage, String health, String armor) {
        this.name = name;
        if (tryParseInt(demage)) {
            this.demage = Integer.parseInt(demage);
        } else {
            this.demage = DEMAGE_DEF_VALUE;
        }

        if (tryParseInt(health)) {
            this.health = Integer.parseInt(health);
        } else {
            this.health = HEALTH_DEF_VALUE;
        }

        if (tryParseInt(armor)) {
            this.armor = Integer.parseInt(armor);
        } else {
            this.armor = ARMOR_DEF_VALUE;
        }
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}