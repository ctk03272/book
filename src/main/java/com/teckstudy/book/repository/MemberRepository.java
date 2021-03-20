package com.teckstudy.book.repository;

import com.teckstudy.book.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 스프링 데이터 리포지토리에 사용자 정의 인터페이스 상속 (MemberRepositoryCustom)
// QuerydslPredicateExecutor<Member> 생략
public interface MemberRepository extends JpaRepository<Member, Long> {
//    List<Member> findByUsername(String username);
}
