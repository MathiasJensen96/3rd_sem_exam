package dtos;

import entities.User;

public class UserDTO {

    private String userName;
    private String address;
    private int phone;
    private String email;
    private int birthYear;
    private String gender;

    public UserDTO() {
    }

    public UserDTO(User u) {
        this.userName = u.getUserName();
        this.address = u.getAddress();
        this.phone = u.getPhone();
        this.email = u.getEmail();
        this.birthYear = u.getBirthYear();
        this.gender = u.getGender();
    }
}
