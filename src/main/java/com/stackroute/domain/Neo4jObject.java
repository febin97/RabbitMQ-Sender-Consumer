package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neo4jObject {
    private Node name;
    private Node dateOfBirth;
    private Node gender;
    private Node motherTongue;
    private Node religion;
    private Node caste;
    private Node height;
    private Node weight;
    private Node mobileNumber;
}
