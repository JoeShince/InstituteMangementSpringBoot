package com.sample.institutemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.Subst;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "institute")
public class Institute {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    public String id;
    public String name;
    public String address;
    public String contactMail;
    @Pattern("(^$|[0-9]{10})")
    public String contactPrimaryPhone;

    public Institute(String name, String address, @Subst("") String contactPrimaryPhone) {
        this.name = name;
        this.address = address;
        this.contactPrimaryPhone = contactPrimaryPhone;
    }
}
