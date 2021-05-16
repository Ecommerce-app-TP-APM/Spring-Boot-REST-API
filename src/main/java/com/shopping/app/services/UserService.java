package com.shopping.app.services;

import com.shopping.app.domain.User;
import com.shopping.app.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
