package com.simple.webservice.service.member;

import org.springframework.stereotype.Service;

import com.simple.webservice.model.MemberDAO;
import com.simple.webservice.model.MemberDTO;
import com.simple.webservice.mysqljdbc.MysqlJdbcMemberDAO;

import java.sql.SQLException;

@Service
public class MemberServiceImpl implements MemberService {
    private final MysqlJdbcMemberDAO memberDAOService;
    public MemberServiceImpl(MysqlJdbcMemberDAO memberDAOService) {
        this.memberDAOService = memberDAOService;
    }

    public MemberDTO getMemberData(int id){
        MemberDTO member = fetchMemberData(id);
        return member;
    }

    private MemberDTO fetchMemberData(int id){
        MemberDTO member = new MemberDTO();

        try {
            System.out.println("Member id"+id);
            MemberDAO memberDAO = memberDAOService.getMemberDataById(id);

            member.setMemberName(memberDAO.getMemberName());
            member.setAge(memberDAO.getAge());
            member.setCity(memberDAO.getCity());
            member.setId(memberDAO.getId());

            return member;
        }
        catch (SQLException e){
            return null;
        }
    }
}
