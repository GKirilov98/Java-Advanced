package p02_KingsGambit;

abstract class Unit  {
    private String name;

    Unit(String name){
        this.name = name;
    }

    String getName() {
        return name;
    }
}
