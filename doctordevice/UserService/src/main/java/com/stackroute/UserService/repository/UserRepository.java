package com.stackroute.UserService.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.UserService.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
 public interface UserRepository extends MongoRepository<User, UUID>
{
  Optional<User> findByEmail(String email);
}
