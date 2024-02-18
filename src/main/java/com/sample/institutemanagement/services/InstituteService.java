package com.sample.institutemanagement.services;

import com.sample.institutemanagement.dto.UpdateInstituteDto;
import com.sample.institutemanagement.exceptions.ResourceNotFoundException;
import com.sample.institutemanagement.models.Institute;
import com.sample.institutemanagement.repositories.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InstituteService {

@Autowired public InstituteRepository instituteRepository;
    public Institute registerInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    public void updateInstitute(UpdateInstituteDto instituteEntity) {
        Institute institute = instituteRepository.findInstituteById(instituteEntity.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Institute not exist with id: " + instituteEntity.getId()));
        institute.setAddress(instituteEntity.getAddress());
        institute.setName(instituteEntity.getAddress());
        institute.setContactMail(instituteEntity.getAddress());
        institute.setContactPrimaryPhone(instituteEntity.getContactPrimaryPhone());

        instituteRepository.save(institute);
    }

    public Optional<Institute> getInstitute(String id)  {
        return instituteRepository.findInstituteById(id);
    }
}
