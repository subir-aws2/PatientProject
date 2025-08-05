package com.AdminPanel.PatientAdminService.Service.ImplClass;

import com.AdminPanel.PatientAdminService.DTO.PatientDto;
import com.AdminPanel.PatientAdminService.Entity.PatientDetails;
import com.AdminPanel.PatientAdminService.Entity.PatientSequenceGenerator;
import com.AdminPanel.PatientAdminService.Repository.PatientRepository;
import com.AdminPanel.PatientAdminService.Service.Interface.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PatientServiceImpl implements PatientService {


    PatientRepository patientRepository ;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Autowired
    private PatientSequenceGenerator patientSequenceGenerator;


    @Override
    public PatientDto createPatient(PatientDto patientDto) {

        PatientDetails patientDetails = new PatientDetails();

        patientDetails.setPatientId(patientSequenceGenerator.getNextVal("patient_sequence"));
        patientDetails.setFirstName(patientDto.getFirstName());
        patientDetails.setLastName(patientDto.getLastName());
        patientDetails.setContactNumber(patientDto.getContactNumber());
        patientDetails.setDateOfBirth(patientDto.getDateOfBirth());
        if (patientDto.getEmail() != null){
            patientDetails.setEmail(patientDetails.getEmail());
        }
        patientDetails.setCreatedDate(LocalDateTime.now());
        patientDetails.setLastVisitedDate(LocalDateTime.now());
        if (patientDto.getRegisteredBy() != null){
            patientDetails.setRegisteredBy(patientDetails.getRegisteredBy());
        }
        if(patientDto.getNote() != null){
            patientDetails.setNote(patientDto.getNote());
        }

        PatientDetails savePatient = patientRepository.save(patientDetails);
        PatientDto savedPatient = new PatientDto();
        savedPatient.setFirstName(savePatient.getFirstName());
        savedPatient.setLastName(savePatient.getLastName());
        return savedPatient;

    }
}
