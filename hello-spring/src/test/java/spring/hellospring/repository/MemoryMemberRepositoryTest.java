package spring.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import spring.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.hellospring.repository.MemberRepository;
import spring.hellospring.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // 모든 test는 순서에 상관없이 메소드 별로 따로 동작하도록 설계해야한다. (순서에 의존적으로 설계XX)
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날때마다 호출되어 저장소와 데이터들을 클리어 해줘서 순서가 상관 없어지게 된다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();   // 새로운 member를 만들고
        member.setName("spring");       // name을 spring이라고 set

        repository.save(member);        // 만든 member를 save

        // System.out.println("result = " + (result == member));
        Member result = repository.findById(member.getId()).get();  // id를 get해온다
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 단축키 : ctrl + shift + alt + v
        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // member1
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // member2
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
