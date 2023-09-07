package com.groom.domain.business.repository;

import com.groom.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Query("select b from Business b where b.member.id = :memberId")
    List<Business> findBusinessByMemberId(@Param("memberId") Long memberId);
}