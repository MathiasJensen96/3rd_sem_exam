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
    private long guideID;

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
        this.guideID = t.getGuide().getId();
    }

    public TripDTO(String name, String date, String time, String location, String duration, String packingList, long guideID) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packingList = packingList;
        this.guideID = guideID;
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

    public long getGuideID() {
        return guideID;
    }

    public void setGuideID(long guideID) {
        this.guideID = guideID;
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
