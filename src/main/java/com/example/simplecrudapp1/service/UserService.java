package com.example.simplecrudapp1.service;

import com.example.simplecrudapp1.api.AddUserReq;
import com.example.simplecrudapp1.response.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> addUser(AddUserReq req);
    ResponseEntity<Response> findAllUsers();
}
