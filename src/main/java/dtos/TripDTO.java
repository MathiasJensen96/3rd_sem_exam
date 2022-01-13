package dtos;

import entities.Trip;

public class TripDTO {

    private Long id;
    private String name;
    private String date;
    private String time;
    private String location;
    private String duration;
    private String packingList;
    private String guideName;

    public TripDTO() {
    }

    public TripDTO(Trip t) {
        this.id = t.getId();
        this.name = t.getName();
        this.date = t.getDate();
        this.time = t.getTime();
        this.location = t.getLocation();
        this.duration = t.getDuration();
        this.packingList = t.getPackingList();
        this.guideName = t.getGuide().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", packingList='" + packingList + '\'' +
                '}';
    }
}
