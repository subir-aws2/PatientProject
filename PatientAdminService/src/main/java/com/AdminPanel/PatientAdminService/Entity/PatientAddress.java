package com.AdminPanel.PatientAdminService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class PatientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long patientId;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private int postalCode;

    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Size(max = 6, min = 6)
    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Size(max = 6, min = 6) int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NotNull
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull long patientId) {
        this.patientId = patientId;
    }
}
