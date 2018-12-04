package mq.springboot.user.responsiry;

import mq.springboot.user.responsiry.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserResponsity extends JpaRepository<UserInfo, Long> {
    @Query(value = "select * from user_info where username = :username", nativeQuery = true)
    UserInfo findByUsername(@Param("username") String username);
}
