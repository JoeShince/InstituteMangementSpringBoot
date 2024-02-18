package com.sample.institutemanagement.repositories;

import com.sample.institutemanagement.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, String> {

    Optional<Institute> findInstituteById(String id);
}
