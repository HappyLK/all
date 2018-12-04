package mq.springboot.user.responsiry;

import mq.springboot.user.responsiry.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponsity extends JpaRepository<UserInfo, Long> {
}
