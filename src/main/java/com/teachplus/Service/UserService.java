package com.teachplus.Service;

import com.teachplus.Entity.User;
import com.teachplus.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.getOne(id);
    }
}
