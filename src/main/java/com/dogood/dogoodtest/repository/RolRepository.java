package com.dogood.dogoodtest.repository;

import com.dogood.dogoodtest.entity.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findRolByName(String name);

}
