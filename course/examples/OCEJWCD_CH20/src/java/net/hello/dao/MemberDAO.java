package net.hello.dao;

import java.util.List;
import net.hello.domain.Member;

public interface MemberDAO extends AutoCloseable {

    public int add(Member member);

    public void update(Member member);

    public void delete(int id);

    public Member findById(int id);

    public List<Member> getAllMember();
}
