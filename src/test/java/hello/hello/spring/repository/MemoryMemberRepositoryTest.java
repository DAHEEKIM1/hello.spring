package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemberRepository repository=new MemoryMemberRepository();
    //member에 name이 제대로 추가되는지확인하는 코드
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result=repository.findById(member.getId()).get();
        Assertions.assertEquals(result,member);//같은 값인지 비교해주는 코드

    }
//    @Test
//    public void findByName(){
//        Member member1 = new Member();
//        member1.setName("Spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        Member result = repository.findByName("sprint1").get();
//
//        assertThat(result).isEqualTo(member1);
//
//    }

    @Override
    public Optional<Member> findById(Long id) {//null값일때 Optional에 감싸서 return
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByname(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
