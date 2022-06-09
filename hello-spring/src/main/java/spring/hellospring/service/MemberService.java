package spring.hellospring.service;

import spring.hellospring.domain.Member;
import spring.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

// 새로운 테스트 생성 단축키 : ctrl + shift + t
public class MemberService {

    private final MemberRepository memberRepository;

    // 직접 생성하는게 아니라 외부에서 넣어주도록 설정
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join (Member member) {
        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름을 가진 중복회원은 안된다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
