package lk.jiat.bookverselibraryportal.dto;

import lk.jiat.bookverselibraryportal.model.enums.Role;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean status;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email, String firstName, String lastName, boolean status, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.role = role;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
