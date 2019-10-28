package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personal {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String motherTongue;
    private String religion;
    private String caste;
    private float height;
    private float weight;
    private String mobileNumber;
}
