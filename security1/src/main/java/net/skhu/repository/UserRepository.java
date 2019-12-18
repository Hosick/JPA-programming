package net.skhu.repository;

import net.skhu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByLoginId(String loginId);

}
