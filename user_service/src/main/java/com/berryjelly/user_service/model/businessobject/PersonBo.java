package com.berryjelly.user_service.model.businessobject;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonBo {

    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private String companyCode;

}
