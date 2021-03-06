package it.finsoft.RoomReserve.service;

import it.finsoft.RoomReserve.model.Room;
import it.finsoft.RoomReserve.model.User;
import it.finsoft.RoomReserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Room room : user.getRooms()){
            grantedAuthorities.add(new SimpleGrantedAuthority(room.getHour1()));
            grantedAuthorities.add(new SimpleGrantedAuthority(room.getHour2()));
            grantedAuthorities.add(new SimpleGrantedAuthority(room.getHour3()));
            grantedAuthorities.add(new SimpleGrantedAuthority(room.getHour4()));
            grantedAuthorities.add(new SimpleGrantedAuthority(room.getHour5()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}