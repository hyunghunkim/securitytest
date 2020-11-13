package org.secu.service;

import org.secu.domain.MemberVO;


public interface MemberService {

    public void insert(MemberVO memberVO);
    public int userIdCheck(String username);
}
