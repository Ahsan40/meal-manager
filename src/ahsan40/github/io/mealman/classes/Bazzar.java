package ahsan40.github.io.mealman.classes;


import java.time.LocalDateTime;

public class Bazzar {
    private String name;
    private String type;
    private double price;
    private final LocalDateTime date;

    public Bazzar(String name, String type, double price) {
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}