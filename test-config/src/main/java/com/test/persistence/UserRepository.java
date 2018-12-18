package com.test.persistence;

import com.test.model.entity.User;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@EntityScan("com.test.**")
public interface UserRepository extends JpaRepository<User, Long> {

}
