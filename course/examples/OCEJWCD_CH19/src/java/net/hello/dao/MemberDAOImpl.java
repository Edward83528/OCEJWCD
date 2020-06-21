package net.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.hello.domain.Member;

public class MemberDAOImpl implements MemberDAO {

    private String DB_HOST = "localhost";
    private String DB_PORT = "3306";
    private String DB_NAME = "ocejwcd";

    private String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    private String username = "root";
    private String password = "75u8mi7h";

    private Connection con;

    public MemberDAOImpl() throws SQLException {
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        con = DriverManager.getConnection(url, username, password);
        try {
            Context context = new InitialContext();
            
            if (context == null) {
                throw new SQLException("InitialContext error");
            }
            
            DataSource dataSource = (DataSource) context.lookup(
                "java:comp/env/jdbc/ocejwcdDB");
            con = dataSource.getConnection();
        }
        catch (NamingException e) {
            throw new SQLException("InitialContext error", e);
        }
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

    @Override
    public int add(Member member) {
        int result = -1;
        final String SQL = "INSERT INTO Member (FirstName, LastName, BirthDate, Bonus) VALUES (?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, member.getFirstName());
            pstmt.setString(2, member.getLastName());
            pstmt.setDate(3, new java.sql.Date(member.getBirthDate().getTime()));
            pstmt.setDouble(4, member.getBonus());

            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.next()) {
                result = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public void update(Member member) {
        final String SQL = "UPDATE Member SET FirstName=?, LastName=?, BirthDate=?, Bonus=? WHERE ID=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(SQL);

            pstmt.setString(1, member.getFirstName());
            pstmt.setString(2, member.getLastName());
            pstmt.setDate(3, new java.sql.Date(member.getBirthDate().getTime()));
            pstmt.setDouble(4, member.getBonus());
            pstmt.setInt(5, member.getId());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String SQL = "DELETE FROM Member WHERE ID=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Member findById(int id) {
        Member result = null;
        final String SQL = "SELECT * FROM Member WHERE ID=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                Date birthDate = rs.getDate("BirthDate");
                float bonus = rs.getFloat("Bonus");

                result = new Member();
                result.setId(empID);
                result.setFirstName(first);
                result.setLastName(last);
                result.setBirthDate(birthDate);
                result.setBonus(bonus);
            }
        }
        catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }

        return result;
    }

    @Override
    public List<Member> getAllMember() {
        List<Member> result = new ArrayList<>();
        final String SQL = "SELECT * FROM Member";

        try (Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                Date birthDate = rs.getDate("BirthDate");
                float bonus = rs.getFloat("Bonus");

                Member emp = new Member();
                emp.setId(empID);
                emp.setFirstName(first);
                emp.setLastName(last);
                emp.setBirthDate(birthDate);
                emp.setBonus(bonus);

                result.add(emp);
            }
        }
        catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }

        return result;
    }

}
