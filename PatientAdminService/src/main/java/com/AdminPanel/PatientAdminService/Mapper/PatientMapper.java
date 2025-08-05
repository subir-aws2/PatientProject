package com.AdminPanel.PatientAdminService.Mapper;

import com.AdminPanel.PatientAdminService.DTO.PatientDto;
import com.AdminPanel.PatientAdminService.DTO.PatientResponseDto;
import com.AdminPanel.PatientAdminService.Entity.PatientDetails;

public class PatientMapper {


    public PatientResponseDto PatientResponseDtoMapper(PatientDetails patientDetails){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patientDetails.getPatientId());
        patientResponseDto.setFirstName(patientDetails.getFirstName());
        patientResponseDto.setLastName(patientDetails.getLastName());
        patientResponseDto.setContactNumber(patientResponseDto.getContactNumber());
        patientResponseDto.setNote(patientResponseDto.getNote());
        return patientResponseDto;

    }
}
