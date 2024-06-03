package com.simple.webservice.mysqljdbc;

import org.springframework.stereotype.Service;

import com.simple.webservice.model.MemberDAO;

import java.sql.SQLException;

@Service
public interface MysqlJdbcMemberDAO {
    MemberDAO getMemberDataById(int id) throws SQLException;
}
