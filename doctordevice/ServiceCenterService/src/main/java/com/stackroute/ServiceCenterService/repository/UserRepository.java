package com.stackroute.ServiceCenterService.repository;

import java.util.List;
//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.stackroute.ServiceCenterService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
