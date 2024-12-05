package org.example.Zadanie2;

import java.io.Serializable;
import java.util.Objects;

public class Ocean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public Ocean(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocean ocean = (Ocean) o;
        return Objects.equals(name, ocean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Океан{name='" + name + "'}";
    }
}
