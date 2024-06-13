package com.mixalismavromanolakis.car_service_tasks.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @NotNull
    @Size(min = 3, max = 16)
    private String username;

    @Pattern(regexp = "^.{4,}$", message = "Password must contain at least 4 characters.")
    private String password;

    @NotNull
    @Size(min = 3, max = 16, message = "Firstname must contain at least 3 characters.")
    private String firstname;

    @NotNull
    @Size(min = 3, max = 16, message = "Lastname must contain at least 3 characters.")
    private String lastname;

    @NotNull
    private String emailAddress;
    @NotNull
    private String role;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String password, String firstname, String lastname, String emailAddress, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailAddress() { return this.emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
