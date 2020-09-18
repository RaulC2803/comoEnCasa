package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.AuthenticationResponse;
import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody User user){
        return authService.createToken(user);
    }
}
