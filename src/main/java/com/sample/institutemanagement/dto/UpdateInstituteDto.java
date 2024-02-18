package com.sample.institutemanagement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateInstituteDto {
    private String id;
    private String name;
    private String address;
    private String contactMail;
    private String contactPrimaryPhone;
}
