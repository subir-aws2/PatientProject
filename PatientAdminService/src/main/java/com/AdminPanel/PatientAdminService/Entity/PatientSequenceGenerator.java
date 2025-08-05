package com.AdminPanel.PatientAdminService.Entity;

import com.AdminPanel.PatientAdminService.Repository.IdSequenceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PatientSequenceGenerator {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private  IdSequenceRepository idSequenceRepository;

    private static final int INCREMENT=12;
    private static final int MIN_RANDOM=100000;
    private static final int MAX_RANDOM=999999;
    private final Random random = new Random();


    @Transactional
    public Long getNextVal(String sequenceName){

        if(sequenceName == null || sequenceName.isBlank()){
            throw new IllegalArgumentException("Sequence Name Should not be null");
        }

        IdSequence existingSequenceCheck = idSequenceRepository.findById(sequenceName).orElse(null);
        if (existingSequenceCheck !=null){
            long nextValue = existingSequenceCheck.getCurrentValue() ;
            int attempts =0;
            while (attempts < 999){
                nextValue +=INCREMENT;
                boolean valueNext = idSequenceRepository.existsByCurrentValue(nextValue);
                if (!valueNext){
                    existingSequenceCheck.setCurrentValue(nextValue);
                    idSequenceRepository.save(existingSequenceCheck);
                    return nextValue;
                }
                attempts++;
            }
        }else {
            Set<Long> useValues = idSequenceRepository.findAll().stream()
                    .map(IdSequence::getCurrentValue)
                    .collect(Collectors.toSet());

            long newValue = generatedUniqueRandomValue(useValues);

            IdSequence idSequence = new IdSequence();
            idSequence.setSequenceName(sequenceName);
            idSequence.setCurrentValue(newValue);
            idSequenceRepository.save(idSequence);

            return newValue;
        }
        return null;
    }


    private long generatedUniqueRandomValue(Set<Long> usedValue) {
        int attempts = 0;
        while (attempts < 999) {
            long randomValue = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
            if (!usedValue.contains(randomValue)) {
                return randomValue;
            }

            attempts++;
        }
        throw new IllegalStateException("Unable to Find unique 6 digit value after 999 attempts");
    }
}
