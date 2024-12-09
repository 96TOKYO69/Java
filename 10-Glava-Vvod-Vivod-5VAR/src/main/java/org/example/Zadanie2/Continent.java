package org.example.Zadanie2;

import java.io.Serializable;
import java.util.Objects;

public class Continent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public Continent(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Континет{name='" + name + "'}";
    }
}
