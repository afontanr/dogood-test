package com.dogood.dogoodtest.repository;

import com.dogood.dogoodtest.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsername(String username);

}
