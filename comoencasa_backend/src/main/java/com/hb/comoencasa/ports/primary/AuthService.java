package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.adapters.security.JWTUtil;
import com.hb.comoencasa.domain.AuthenticationRequest;
import com.hb.comoencasa.domain.AuthenticationResponse;
import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.cecUserDetailsService;
import com.hb.comoencasa.ports.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private cecUserDetailsService CecUserDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public ResponseEntity<AuthenticationResponse> createToken(User user){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = CecUserDetailsService.loadUserByUsername(user.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    public User RegisterUser(User u){
        return userRepository.save(u);
    }
}
