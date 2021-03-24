package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberReository memberReository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memberReository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberReository.findByName(member.getName())
                .ifPresent(m -> { //값이 있으면, optional로 감싸져 있을때 가능
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberReository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberReository.findById(memberId);
    }
}
