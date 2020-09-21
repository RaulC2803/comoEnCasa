package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.ports.secondary.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.hb.comoencasa.ports.secondary.RoleRepository;


@Service
public class CompradorService {
    @Autowired
    private CompradorRepository compradorRepository;

    //@Autowired
    //private RoleRepository roleRepository;
//
    //@Autowired
    //private cecUserDetailsService CecUserDetailsService;



    public Comprador register(Comprador comprador) throws Exception {
       Comprador c = null;
       c = comprador;

       if(c == null){
           throw new Exception("No se pudo registrar");
       }else{
           System.out.println("Comprador Registrado");
           return compradorRepository.save(c);
       }
    }
}
