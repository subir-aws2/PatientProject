package com.AdminPanel.PatientAdminService.Controller;

import com.AdminPanel.PatientAdminService.DTO.PatientDto;
import com.AdminPanel.PatientAdminService.DTO.PatientResponseDto;
import com.AdminPanel.PatientAdminService.Service.Interface.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> patients(){
        List<PatientResponseDto> patientResponseDtos = patientService.getPatientList();
        return new ResponseEntity<>(patientResponseDtos, HttpStatus.OK);
    }

}
