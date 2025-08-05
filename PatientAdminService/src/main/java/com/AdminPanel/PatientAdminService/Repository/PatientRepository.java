package com.AdminPanel.PatientAdminService.Repository;

import com.AdminPanel.PatientAdminService.Entity.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails,Long> {
}
