package com.example.simplecrudapp1.dao;

import com.example.simplecrudapp1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao {
    void insertNewUser(User user);
    List<User> getAllUser();
    boolean isExistsNickname(String nickname);
}
