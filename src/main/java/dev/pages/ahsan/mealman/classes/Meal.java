package dev.pages.ahsan.mealman.classes;

import java.time.LocalDateTime;

public class Meal {
    private final People people;
    private final LocalDateTime date;
    private boolean rice;
    private boolean curry;

    public Meal(People people, boolean rice, boolean curry) {
        this.people = people;
        this.rice = rice;
        this.curry = curry;
        this.date = LocalDateTime.now();
    }

    public Meal(People people) {
        this(people, true, true);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public People getPeople() {
        return people;
    }

    public boolean isRice() {
        return rice;
    }

    public void setRice(boolean rice) {
        this.rice = rice;
    }

    public boolean isCurry() {
        return curry;
    }

    public void setCurry(boolean curry) {
        this.curry = curry;
    }
}
