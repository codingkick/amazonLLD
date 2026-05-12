package questions.vendingMachine;

public class Product {
    private String name;
    private double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price == product.price;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(price);
    }
}
