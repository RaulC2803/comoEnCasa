package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Role;
import com.hb.comoencasa.ports.secondary.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getRole(String name){
        return roleRepository.getRole(name);
    }
}
