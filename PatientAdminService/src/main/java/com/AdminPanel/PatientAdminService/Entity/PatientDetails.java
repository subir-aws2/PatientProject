package com.AdminPanel.PatientAdminService.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Patient_Details")
public class PatientDetails extends AdministrativeInfo{

    @Id
    private long patientId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private long contactNumber;

    private String Email;


    public PatientDetails() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public @NotNull Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @NotNull
    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotNull long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
