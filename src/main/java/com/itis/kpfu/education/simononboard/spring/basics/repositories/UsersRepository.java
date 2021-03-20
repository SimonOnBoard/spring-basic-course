package com.itis.kpfu.education.simononboard.spring.basics.repositories;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByCurrentConfirmationCode(String code);

    @Query("select u from User u where lower(u.username) like lower(concat('%', :nameToFind,'%')) ")
    Page<User> findAllByUsernameIgnoreCase(@Param("nameToFind") String username,
                                           Pageable pageable);
}
