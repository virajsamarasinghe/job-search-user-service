package com.jobsearch.user_service.dto;


import com.jobsearch.user_service.entity.Role;

import java.util.Set;

public class UserDto {


    private String username; // String type (Unique)
    private String password; // String type (Hashed password)
    private String firstName; // String type
    private String lastName; // String type
    // Enum type for user role (e.g., Admin, User, etc.)
    private String email; // String type (Unique)
    private String phoneNumber; // String type (Optional)

    private Set<Role> role;

    public UserDto() {
    }

    public UserDto( String username, String password, String firstName, String lastName, String email, String phoneNumber, Set<Role> role) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
