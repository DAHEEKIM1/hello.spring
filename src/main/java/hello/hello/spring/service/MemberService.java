package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 가입 안됨
        Optional<Member> result= memberRepository.findByName(member.getName());//optional을 그대로 반환하지 않는다.
        ExtractDuplicateMember(memberRepository.findByName(member.getName()));
        ExtractDuplicateMember(result);
        memberRepository.save(member);
        return member.getId();

    }

    private void ExtractDuplicateMember(Optional<Member> memberRepository) {
        memberRepository
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        //전체 회원 조회
        return MemberRepository.findAll();



    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById((memberID));
    }
}
