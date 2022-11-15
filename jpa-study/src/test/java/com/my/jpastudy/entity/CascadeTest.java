package com.my.jpastudy.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CascadeTest {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("부모를 저장 할 시 자식도 같이 저장 된다.")
    void cascadePersistTest() {
        Child child1 = Child.builder().name("child1").build();
        Child child2 = Child.builder().name("child2").build();
        Parent parent = Parent.builder().name("parent").build();
        parent.addChild(child1);
        parent.addChild(child2);
        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, parent.getId());

        assertThat(findParent.getChildList().size()).isEqualTo(2);
    }
}
