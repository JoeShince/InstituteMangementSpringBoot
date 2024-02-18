package com.sample.institutemanagement.controllers;

import com.sample.institutemanagement.dto.UpdateInstituteDto;
import com.sample.institutemanagement.exceptions.ResourceNotFoundException;
import com.sample.institutemanagement.models.Institute;
import com.sample.institutemanagement.services.InstituteService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institute")
@RequiredArgsConstructor
public class InstituteController {

@Autowired
public InstituteService instituteService;

    @PostMapping
    public Institute instituteRegistration(@RequestBody @NonNull Institute institute){
        return instituteService.registerInstitute( institute);
    }

    @PutMapping
    public void instituteUpdate(@RequestBody @NonNull UpdateInstituteDto instituteRequest){
        instituteService.updateInstitute(instituteRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute> fetchInstitute(@PathVariable @NonNull String id) {
        Institute instituteEntity = instituteService.getInstitute(id).
                orElseThrow(() -> new ResourceNotFoundException("Institute not exist with id: " + id));
        return ResponseEntity.ok(instituteEntity);
    }
}
