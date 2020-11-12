package org.secu.domain;

import lombok.Data;

import java.util.List;

@Data
public class MemberVO {
    private String username;
    private String password;
    private String name;
    private String auth;

    private List<AuthVO> authList;
}
