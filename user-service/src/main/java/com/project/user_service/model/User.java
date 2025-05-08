package com.project.user_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private String password;

    private String fullName;
    private String email;
    private Long mobileNumber;
    private String aadharNumber;
    private String panCard;
    private String address;

    private  boolean isActive;

    private Set<String> roles;

}
