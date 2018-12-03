package mq.springboot.responsiry;

import mq.springboot.responsiry.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponsity extends JpaRepository<UserEntity, Long> {
}
