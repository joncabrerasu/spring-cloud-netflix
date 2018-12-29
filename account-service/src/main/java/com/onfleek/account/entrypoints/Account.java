package com.onfleek.account.entrypoints;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Account {

    private String id;

    private String username;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("surname")
    private String surName;

    private String role;
}
