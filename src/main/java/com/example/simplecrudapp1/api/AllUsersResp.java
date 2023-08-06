package com.example.simplecrudapp1.api;

import com.example.simplecrudapp1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllUsersResp {
 private List<User> userList;
}
