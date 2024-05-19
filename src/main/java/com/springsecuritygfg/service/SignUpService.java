package com.springsecuritygfg.service;

import com.springsecuritygfg.model.requestObject.UserRequestObject;

public interface SignUpService {

    public void createUser(UserRequestObject userRequestObject);
}
