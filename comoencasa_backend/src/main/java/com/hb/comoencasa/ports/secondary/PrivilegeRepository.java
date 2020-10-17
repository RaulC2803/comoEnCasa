package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
