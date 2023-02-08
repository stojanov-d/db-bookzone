package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.User;
import dbva.bookzone2.repository.UserRepository;
import dbva.bookzone2.service.AuthService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loginUser(String name, String password) {
        return loadUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByName(name);

        return new org.springframework.security.core.userdetails.User(
                user.getName(),user.getPassword(),
                Stream.of(new SimpleGrantedAuthority("ROLE_"+user.getType().getTypeName())).collect(Collectors.toList())
        );
    }
}
