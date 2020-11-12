package org.secu.mapper;

import org.secu.domain.AuthVO;
import org.secu.domain.MemberVO;

public interface MemberMapper {
    public MemberVO read(String username);
    public int insert(MemberVO memberVO);
    public int insertAuth(AuthVO authVO);
}
