package spring.hellospring.domain;

public class Member {
    private Long id;        // 시스템 임의의 값
    private String name;    // 고객의 이름

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
