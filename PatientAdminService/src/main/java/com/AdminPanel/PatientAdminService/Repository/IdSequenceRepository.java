package com.AdminPanel.PatientAdminService.Repository;

import com.AdminPanel.PatientAdminService.Entity.IdSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdSequenceRepository extends JpaRepository<IdSequence,String> {

    List<IdSequence> findAll();

    boolean existsByCurrentValue(Long currentValue);
}
