package com.AdminPanel.PatientAdminService.Controller;

import com.AdminPanel.PatientAdminService.DTO.PatientDto;
import com.AdminPanel.PatientAdminService.Service.Interface.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto createdPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(createdPatient, HttpStatus.OK);

    }

}
