package com.simple.webservice.service.member;

import org.springframework.stereotype.Service;

import com.simple.webservice.model.MemberDTO;

@Service
public interface MemberService {
    MemberDTO getMemberData(int id);
}
