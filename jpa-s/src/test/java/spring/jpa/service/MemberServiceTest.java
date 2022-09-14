package spring.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;

import spring.jpa.domain.Member;
import spring.jpa.repository.MemberRepository;


@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입(){
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId =memberService.join(member);

        //then
        em.flush(); // db에 반영해줌 테스트끝나면 트랜잭션이 롤백해줌 
        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복회원_예외() throws Exception{
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    
}
