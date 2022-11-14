package com.my.jpastudy.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EntityTest {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("양방향 매핑시 1차캐시 테스트")
    void entityCashDataTest() {
        Team team = new Team("TEAM1");
        em.persist(team);
        Member member = new Member("hello", team);
        em.persist(member);

        Team findTeam = em.find(Team.class, team.getId());
        List<Member> members = findTeam.getMembers();
        assertThat(members).isEmpty();

    }

    @Test
    @DisplayName("양방향 매핑시 객체저장 테스트")
    void memberAndTeamSaveTest() {
        Team team = new Team("TEAM1");
        em.persist(team);
        Member member = new Member("hello", team);
        team.getMembers().add(member);
        em.persist(member);

        em.clear();
        Team findTeam = em.find(Team.class, team.getId());
        Member findMember = em.find(Member.class, member.getId());

        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember.getTeam()).isEqualTo(findTeam);
        assertThat(findTeam.getMembers().get(0)).isEqualTo(findMember);
    }

    @Test
    @DisplayName("연관관계 편의메소드 테스트")
    void memberChangeTeamTest() {
        Team team = new Team("TEAM1");
        em.persist(team);
        Member member = Member.builder()
                .username("hello")
                .build();
        member.changeTeam(team);
        em.persist(member);

        em.clear();

        Team findTeam = em.find(Team.class, team.getId());
        Member findMember = em.find(Member.class, member.getId());

        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember.getTeam()).isEqualTo(findTeam);
        assertThat(findTeam.getMembers().get(0)).isEqualTo(findMember);

    }
}
