package com.tpa.toyproject_api.Register.Repository;

import com.tpa.toyproject_api.Login.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}