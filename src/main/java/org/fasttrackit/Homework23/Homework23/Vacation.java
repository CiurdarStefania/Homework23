package org.fasttrackit.Homework23.Homework23;

import java.util.Objects;

public class Vacation {

    private final int id;
    private final String location;
    private final int price;
    private final int duration;

    public Vacation( int id,String location, int price, int duration) {
        this.location = location;
        this.id = id;
        this.price = price;
        this.duration = duration;
    }


    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacantion = (Vacation) o;
        return id == vacantion.id &&
                price == vacantion.price &&
                duration == vacantion.duration &&
                Objects.equals(location, vacantion.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, id, price, duration);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "location='" + location + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}
