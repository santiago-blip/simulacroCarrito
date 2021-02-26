/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simulacionCarrito.DAO.UsuarioDAO;
import simulacionCarrito.entities.Usuario;

@Service
public class UsuarioLogin implements UserDetailsService {

    @Autowired
    private UsuarioDAO serviceDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Usuario usuario = serviceDAO.findByUsuario(string);
        List<GrantedAuthority> autoritie = new ArrayList<>();
        autoritie.add(new SimpleGrantedAuthority(usuario.getIdRol().getRol()));
        System.out.println("Esto es el ROL QUE PASA: " + usuario.getIdRol().getRol());
        return new User(usuario.getUsuario(), usuario.getPass(), autoritie);
    }

}
