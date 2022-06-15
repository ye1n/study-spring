package spring.hellospring.repository;

import org.springframework.stereotype.Repository;
import spring.hellospring.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2와 같은 키 값을 생성해줌

    // 회원 저장
    @Override
    public Member save(Member member) {
        member.setId(++sequence);           // 저장하기 전에 시퀀스값 1 증가 후 id에 set
        store.put(member.getId(), member);
        return member;
    }

    // id로 회원 조회
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null이여도 감싸서 반환하면 클라이언트에서 뭘 할 수 있음 ..!!!
    }

    // name으로 회원 조회
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                // member.getName()이 파라미터로 넘어온 name과 같은지 검사 (자바 람다식)
                .findAny(); // 하나라도 찾는다면 반환
    }

    // 지금까지 저장된 모든 회원 리스트 반환
    @Override
    // store에 있는 values = member 반환
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
