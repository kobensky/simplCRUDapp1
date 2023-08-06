package com.example.simplecrudapp1.service.impl;

import com.example.simplecrudapp1.api.AddUserReq;
import com.example.simplecrudapp1.api.AddUserResp;
import com.example.simplecrudapp1.api.AllUsersResp;
import com.example.simplecrudapp1.dao.UserDao;
import com.example.simplecrudapp1.entity.User;
import com.example.simplecrudapp1.response.Response;
import com.example.simplecrudapp1.response.SuccessResponse;
import com.example.simplecrudapp1.response.exception.CommonException;
import com.example.simplecrudapp1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<Response> addUser(AddUserReq req) {
        if(userDao.isExistsNickname(req.getNickname())) {
            return new ResponseEntity<>(SuccessResponse.builder()
                    .data(CommonException.builder().message("Nickname занят").httpStatus(HttpStatus.BAD_REQUEST).build()).build(), HttpStatus.BAD_REQUEST);
            //throw CommonException.builder().message("Nickname занят").httpStatus(HttpStatus.BAD_REQUEST).build();

        }
        userDao.insertNewUser(User.builder().name(req.getName()).nickname(req.getNickname()).age(req.getAge()).build());
        return new ResponseEntity<>(SuccessResponse.builder()
                .data(AddUserResp.builder().tnx("Tnx Bro").nickname(req.getNickname()).build()).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> findAllUsers() {
        List<User> userList = userDao.getAllUser();
        return new ResponseEntity<>(SuccessResponse.builder()
                .data(AllUsersResp.builder().userList(userList).build()).build()
                , HttpStatus.OK);
    }
}
