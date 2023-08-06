package com.example.simplecrudapp1.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserReq {
    private String name;
    private String nickname;
    private int age;
}
