package p04_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;


public class Person {

    private String name;
    private double money;
    private List<String> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public List<String> getProducts() {
        return products;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.contentEquals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }


    public void buyProduct(Product product) {
        if (this.getMoney() >= product.getCost()) {
            this.products.add(product.getName());
            this.money -= product.getCost();
            boughtProduct(product);
        }else {
            noMoney(product);
        }
    }

    private void boughtProduct(Product product) {
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    private void noMoney(Product product){
        System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
    }
}
