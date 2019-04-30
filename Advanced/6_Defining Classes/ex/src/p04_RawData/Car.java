package p04_RawData;

class Car {
    //class Car that holds information about model, engine, cargo and a collection of exactly 4 tires
    //(engine, cargo and tires)
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    //    public Car(String model, int enginSpeed, int enginePower, int cargoWeight, String cargoType, double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age
//    ) {
//        this.model = model;
//
//    }
}
