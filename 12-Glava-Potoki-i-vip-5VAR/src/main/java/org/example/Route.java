package org.example;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<BusStop> stops;

    public Route(int stopsCount, int capacityPerStop) {
        stops = new ArrayList<>();
        for (int i = 0; i < stopsCount; i++) {
            stops.add(new BusStop("Остановка " + (i + 1), capacityPerStop));
        }
    }

    public BusStop getStop(int index) {
        return stops.get(index);
    }

    public int getStopsCount() {
        return stops.size();
    }
}
