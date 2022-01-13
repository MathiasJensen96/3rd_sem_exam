package dtos;

import entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripsDTO {

    List<TripDTO> all = new ArrayList();

    public TripsDTO(List<Trip> tripEntities) {
        tripEntities.forEach((t) -> {
            if (t == null) return;
            all.add(new TripDTO(t));
        });
    }

    public List<TripDTO> getAll() {
        return all;
    }
}
