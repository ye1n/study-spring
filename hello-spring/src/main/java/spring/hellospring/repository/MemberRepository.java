package spring.hellospring.repository;

import spring.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);                 // 회원 저장
    // Optional : 자바 8의 기능, null일 경우 감싸서 반환할때 사용
    Optional<Member> findById(Long id);         // id로 회원 조회
    Optional<Member> findByName(String name);   // name으로 회원 조회
    List<Member> findAll();                     // 지금까지 저장된 모든 회원 리스트 반환
}
