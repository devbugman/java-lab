package com.my.jpastudy.entity;

import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class ProxyTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private EntityManagerFactory emf;

    @Test
    @DisplayName("em.getReference 조회시 실제 엔티티객체가 아니다")
    void proxyNotRealObjectTest() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());

        assertThat(reference.getClass()).isNotInstanceOf(Member.class);
    }

    @Test
    @DisplayName("find를 조회 후 프록시 조회 시 같은 객체이다")
    void sameObjectProxyAfterLookingUpTheFind() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember = " + findMember.getClass());
        Member reference = em.getReference(Member.class, member.getId());
        System.out.println("reference = " + reference.getClass());

        System.out.println("findMember == reference" + (findMember == reference));
        assertThat(findMember).isEqualTo(reference);
    }

    @Test
    @DisplayName("프록시를 조회 후 find를 조회해도 같은 객체이다")
    void sameObjectFindAfterLookingUpTheProxy() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());
        System.out.println("reference = " + reference.getClass());
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember = " + findMember.getClass());

        System.out.println("reference == findMember" + (reference == findMember));

        assertThat(reference).isEqualTo(findMember);

    }

    @Test
    @DisplayName("준영속 상태일 때, 프록시를 초기화하면 LazyInitializationException 예외가 발생한다")
    void initializeExceptionTest() {
        Member member = createMember("HelloJPA");
        em.persist(member);
        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());

        em.clear(); // em.detach, em.
        assertThatThrownBy(() -> reference.getUsername())
                .isInstanceOf(LazyInitializationException.class);
    }

    @Test
    @DisplayName("proxy 초기화 여부 테스트 1")
    void initializeTest1() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(reference);

        assertThat(loaded).isFalse();
    }

    @Test
    @DisplayName("proxy 초기화 여부 테스트 강제 호출 초기화")
    void initializeTest2() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());
        reference.getUsername();
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(reference);

        assertThat(loaded).isTrue();
    }

    @Test
    @DisplayName("proxy 초기화 여부 테스트 Hibernate.initialize()")
    void initializeTest3() {
        Member member = createMember("hello");
        em.persist(member);

        em.flush();
        em.clear();

        Member reference = em.getReference(Member.class, member.getId());
        Hibernate.initialize(reference);
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(reference);

        assertThat(loaded).isTrue();

    }

    private Member createMember(String username) {
        return Member
                .builder()
                .username(username)
                .build();
    }

}
