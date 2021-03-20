package com.teckstudy.book.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.domain.entity.Gender;
import com.teckstudy.book.domain.entity.Member;
import com.teckstudy.book.domain.entity.MemberStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {
    @Autowired // 또는 자바 표준 스택 @PersistenceContext 최신버전부터 @Autowired 지원 됨
    EntityManager em;

    // queryDsl 선언
    JPAQueryFactory queryFactory;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void testEntity() {
        queryFactory = new JPAQueryFactory(em);
        Member member1 = new Member("member1", "1234", "홍길동", Gender.MALE,
                "1990-09-12", "010-2027-1163", "서울특별시 봉천동",  true,  MemberStatus.NORMAL);
        em.persist(member1);

        em.flush();
        em.clear();
    }

    @Test
    public void startQuerydsl() {
        // 엔티티가 없을때는 반드시 빌드를 해줘야합니다. (Gradle -> querydsl < Tasks < other < compileQuerydsl
        // QMember m = new QMember("m"); // 방법 1
        // QMember m = QMember.member; // 방법 2
        // 방법 : 매개변수 파라미터에 QMember.member 선언 후 alt+enter를 통해 static 선언
//        Member findMember = queryFactory
//                .select(member)
//                .from(member)
//                .where(member.member_id.eq("member1"))
//                .fetchOne();
        List<Member> findMember = memberRepository.findAll();

        assertThat(findMember.get(0).getMember_id()).isEqualTo("member1");

//        assertThat(findMember.getMember_id()).isEqualTo("member1");
    }
}