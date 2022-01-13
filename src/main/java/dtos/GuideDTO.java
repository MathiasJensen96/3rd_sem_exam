package dtos;

import entities.Guide;

public class GuideDTO {

    private Long id;
    private String name;
    private String gender;
    private int birthYear;
    private String profile;
    private String imageURL;

    public GuideDTO() {
    }

    public GuideDTO(Guide g) {
        this.name = g.getName();
        this.gender = g.getGender();
        this.birthYear = g.getBirthYear();
        this.profile = g.getProfile();
        this.imageURL = g.getImageURL();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "GuideDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthYear=" + birthYear +
                ", profile='" + profile + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
