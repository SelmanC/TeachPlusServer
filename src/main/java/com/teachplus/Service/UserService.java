package com.teachplus.Service;

import com.teachplus.Entity.User;
import com.teachplus.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Collection<User> getAllUsersByRole(String role) {
        return userRepository.findByRole(role);
    }


    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    public Collection<User> getChildrenById(long id) {
        return userRepository.findChildren(id);
    }

    public User getUserByCredentials(long workSpaceId, String email, String password) {
        return userRepository.findByWorkspaceIdAndEmailIgnoreCaseAndPassword(workSpaceId, email, password);
    }

    public User addUser(User user) {
        if(user.getId() != null) {
            User currUser = userRepository.findById(user.getId()).get();
            user.setPassword(currUser.getPassword());
        }
        return userRepository.save(user);
    }

    @Transactional
    public void addChildren(Long userId, Collection<User> children) {
        userRepository.deleteFamiliyByParent(userId);
        for(User child : children) {
            userRepository.createChildren(userId, child.getId());
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
