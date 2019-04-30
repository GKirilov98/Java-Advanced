package p07_Google;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
