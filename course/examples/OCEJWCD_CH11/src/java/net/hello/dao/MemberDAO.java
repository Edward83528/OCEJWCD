package net.hello.dao;

import java.sql.SQLException;
import java.util.List;
import net.hello.domain.Member;

public interface MemberDAO extends AutoCloseable {
    public boolean add(Member member) throws SQLException;
    public boolean update(Member member) throws SQLException;
    public boolean delete(int id) throws SQLException;
    public Member get(int id) throws  SQLException;
    public List<Member> getAll() throws SQLException;
}
