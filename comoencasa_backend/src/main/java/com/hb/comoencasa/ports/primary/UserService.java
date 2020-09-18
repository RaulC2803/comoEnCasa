package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User registar(User u){
        return userRepository.save(u);
    }
}
