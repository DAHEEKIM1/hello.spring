package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//id, name가져올때, null을 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();//지금까지 저장된 모든 회원 반환

}
