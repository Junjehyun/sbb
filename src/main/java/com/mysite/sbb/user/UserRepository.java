package com.mysite.sbb.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    // SiteUser의 기본타입은 Long이므로 ..

    // UserSecurityService는 사용자ID를 조회하는 기능이 필요하므로, 다음과 같이 사용자 ID
    // 로 SiteUser 엔티티를 조회하는 findByuserName 메서드를 User 레파지토리에 추가하자.
    Optional<SiteUser> findByusername(String username);
}
