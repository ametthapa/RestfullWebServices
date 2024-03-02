package com.amrit.rest.webservices.restfullwebservices.user.jpa;

import com.amrit.rest.webservices.restfullwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
