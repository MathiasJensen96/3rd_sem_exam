package dtos;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRestDTO {

    private String userName;
    private List<TripDTO> tripDTOList;

    public UserRestDTO(User u) {
        this.userName = u.getUserName();
        this.tripDTOList = new ArrayList<>();
    }

    public UserRestDTO(String userName, List<TripDTO> tripDTOList) {
        this.userName = userName;
        this.tripDTOList = tripDTOList;
    }

    public UserRestDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TripDTO> getTripDTOList() {
        return tripDTOList;
    }

    public void setTripDTOList(List<TripDTO> tripDTOList) {
        this.tripDTOList = tripDTOList;
    }
}
