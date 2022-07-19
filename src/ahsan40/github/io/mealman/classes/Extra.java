package ahsan40.github.io.mealman.classes;

import java.time.LocalDateTime;

public class Extra {
    private String name;
    private double price;
    private final LocalDateTime date;

    public Extra(String name, double price) {
        this.name = name;
        this.price = price;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
