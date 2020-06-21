package net.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.hello.domain.Member;

public class MemberJdbcDAO implements MemberDAO {
    
    private Connection con;
    
    public MemberJdbcDAO(String host, String port, String db, String username, 
            String password) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String JDBC_URL = "jdbc:mysql://" + host + ":" + port + "/" + db;
        con =  DriverManager.getConnection(JDBC_URL, username, password);
    }
    
    @Override
    public void close() throws SQLException {
        con.close();
    }
    
    @Override
    public boolean add(Member member) throws SQLException {
        boolean result = false;
        
        String INSERT_SQL = "INSERT INTO member VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(INSERT_SQL);
        ps.setInt(1, member.getId());
        ps.setString(2, member.getFirstName());
        ps.setString(3, member.getLastName());
        ps.setDate(4, new java.sql.Date(member.getBirthDate().getTime()));
        ps.setDouble(5, member.getBonus());
        
        if (ps.executeUpdate() == 1) {
            result = true;
        }
        
        return result;
    } 
    
    @Override
    public boolean update(Member member) throws SQLException {
        boolean result = false;
        
        String UPDATE_SQL = "UPDATE member " +
                            "SET FirstName=?, LastName=?, BirthDate=?, Bonus=? " +
                            "WHERE id=?";
        PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
        ps.setString(1, member.getFirstName());
        ps.setString(2, member.getLastName());
        ps.setDate(3, new java.sql.Date(member.getBirthDate().getTime()));
        ps.setDouble(4, member.getBonus());
        ps.setInt(5, member.getId());
        
        if (ps.executeUpdate() == 1) {
            result = true;
        }
        
        return result;
    }
    
    @Override
    public boolean delete(int id) throws SQLException {
        boolean result = false;
        
        String DELETE_SQL = "DELETE FROM member WHERE id=?";
        PreparedStatement ps = con.prepareStatement(DELETE_SQL);
        ps.setInt(1, id);
        
        if (ps.executeUpdate() == 1) {
            result = true;
        }
        
        return result;
    }
    
    @Override
    public Member get(int id) throws SQLException {
        Member result = null;
        
        String QUERY_SQL = "SELECT * FROM member WHERE id=?";
        PreparedStatement ps = con.prepareStatement(QUERY_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int mid = rs.getInt("id");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            Date birthDate = rs.getDate("BirthDate");
            double bonus = rs.getDouble("Bonus");
            
            result = new Member(mid, firstName, lastName, birthDate, bonus);
        }
        
        return result;
    }
    
    @Override
    public List<Member> getAll() throws SQLException {
        List<Member> result = new ArrayList<>();
        
        String QUERY_SQL = "SELECT * FROM member";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY_SQL);
        
        while (rs.next()) {
            int mid = rs.getInt("id");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            Date birthDate = rs.getDate("BirthDate");
            double bonus = rs.getDouble("Bonus");
            
            Member m = new Member(mid, firstName, lastName, birthDate, bonus);
            result.add(m);
        }
        
        return result;
    }
    
}
