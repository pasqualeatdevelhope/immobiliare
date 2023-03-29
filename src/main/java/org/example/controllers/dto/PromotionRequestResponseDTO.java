package org.example.controllers.dto;

import jakarta.persistence.Id;

import java.util.Date;

public class PromotionRequestResponseDTO {

    @Id
    private String username;

    private String email;

    private Date requestDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public PromotionRequestResponseDTO() {
    }
}
