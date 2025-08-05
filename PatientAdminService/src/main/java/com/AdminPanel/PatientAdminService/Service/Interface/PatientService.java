package com.AdminPanel.PatientAdminService.Service.Interface;

import com.AdminPanel.PatientAdminService.DTO.PatientDto;
import com.AdminPanel.PatientAdminService.DTO.PatientResponseDto;

import java.util.List;

public interface PatientService {

    PatientDto createPatient(PatientDto patientDto);

    List<PatientResponseDto> getPatientList();
}
