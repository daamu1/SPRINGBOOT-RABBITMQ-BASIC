package com.rabbitmq.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Needed for JSON deserialization
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}
