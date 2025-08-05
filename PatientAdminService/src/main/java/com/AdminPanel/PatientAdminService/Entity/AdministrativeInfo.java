package com.AdminPanel.PatientAdminService.Entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;



@MappedSuperclass
public class AdministrativeInfo {

    @NotNull
    private LocalDateTime createdDate;

    private LocalDateTime lastVisitedDate;

    private String registeredBy;

    @Size(max = 200)
    private String note;


    public @NotNull LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(@NotNull LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastVisitedDate() {
        return lastVisitedDate;
    }

    public void setLastVisitedDate(LocalDateTime lastVisitedDate) {
        this.lastVisitedDate = lastVisitedDate;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public @Size(max = 200) String getNote() {
        return note;
    }

    public void setNote(@Size(max = 200) String note) {
        this.note = note;
    }
}
