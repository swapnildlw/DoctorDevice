package com.stackroute.ServiceCenterService.service;

import com.stackroute.ServiceCenterService.model.User;
import com.stackroute.ServiceCenterService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCenterService implements ServiceCenterServiceI{
@Autowired
UserRepository ur;



@Override
public User saveUser(User user) {
        return ur.save(user);
    }
}
