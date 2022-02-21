package com.tma.accountservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class AccountDTO {

    private Long id;

    private String name;

    private String username;

    private String password;

    private Set<String> roles;

}
