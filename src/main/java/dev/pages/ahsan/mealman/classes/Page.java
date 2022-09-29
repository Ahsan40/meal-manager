package dev.pages.ahsan.mealman.classes;

public class Page {
    public String name;
    public String location;
    public boolean activated;

    public Page(String name, String location) {
        this.name = name;
        this.location = location;
        this.activated = false;
    }


    public Page(String name, String location, boolean activated) {
        this(name, location);
        this.activated = activated;
    }
}
