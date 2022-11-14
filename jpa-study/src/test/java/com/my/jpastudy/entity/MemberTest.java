package com.my.jpastudy.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberTest {

    @Autowired
    EntityManager em;

    @BeforeEach
    public void setUp() {
        Team team = new Team("TEAM1");
        em.persist(team);
        Member member = new Member("hello", team);
        em.persist(member);
        em.clear();
    }

    @Test
    @DisplayName("저장이 잘되었는지 테스트")
    void memberSaveTest() {
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        Member member = members.get(0);
        String username = member.getUsername();

        assertThat(username).isEqualTo("hello");
    }
}