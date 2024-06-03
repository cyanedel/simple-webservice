package com.simple.webservice.mysqljdbc;

import org.springframework.stereotype.Service;

import com.simple.webservice.model.MemberDAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

@Service
public class MysqlJdbcMemberDAOImpl implements MysqlJdbcMemberDAO {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/<db_name>";
    private static final String DATABASE_USERNAME = "<db_username>";
    private static final String DATABASE_PASSWORD = "<db_password>";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the JDBC driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error loading JDBC driver", e);
        }
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    public MemberDAO getMemberDataById(int id) throws SQLException {
        return selectMemberById(id);
    }

    private MemberDAO selectMemberById(int id) throws SQLException {
        String sql = "SELECT * FROM member WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            MemberDAO member = null;
            if (resultSet.next()) {
                member = new MemberDAO();
                member.setId(resultSet.getInt("id"));
                member.setMemberName(resultSet.getString("memberName"));
                member.setAge(resultSet.getInt("age"));
                member.setCity(resultSet.getString("city"));
            }

            resultSet.close();
            statement.close();
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error selectMemberById", e);
        }
    }
}
