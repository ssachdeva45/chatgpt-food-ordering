package com.gpt.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    private double total;

    private String status;

    @PrePersist
    public void prePersist() {
        this.creationDateTime = LocalDateTime.now();
    }

    // Getters and setters omitted for brevity
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDate getCreationDate() {
        //if creationDateTime is null return current date
        if (creationDateTime == null) {
            return LocalDate.now();
        }
        return creationDateTime.toLocalDate();
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

}
