package dtos;

import entities.Guide;
import entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class GuidesDTO {

    List<GuideDTO> all = new ArrayList<>();

    public GuidesDTO(List<Guide> guideEntities) {
        guideEntities.forEach((g) -> {
            if (g == null) return;
            all.add(new GuideDTO(g));
        });
    }

    public List<GuideDTO> getAll() {
        return all;
    }
}
