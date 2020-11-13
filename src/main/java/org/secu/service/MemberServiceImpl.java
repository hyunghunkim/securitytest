package org.secu.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.secu.domain.AuthVO;
import org.secu.domain.MemberVO;
import org.secu.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private PasswordEncoder passwordEncoder;
    private MemberMapper mapper;


    @Override
    public void insert(MemberVO memberVO){
        memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
        log.info(memberVO);
        mapper.insert(memberVO);

        AuthVO authVO = new AuthVO();
        authVO.setUsername(memberVO.getUsername());
        authVO.setAuth(memberVO.getAuth());

        mapper.insertAuth(authVO);
    }

    @Override
    public int userIdCheck(String username) {

        return mapper.checkId(username);
    }


}
