package com.hanghae99.myblog.security;

import com.hanghae99.myblog.model.User;
import com.hanghae99.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("UserDetailServiceImpl의 loadUserByUsername 메소드 실행\n nickname : " + username);
        User user = userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cant's find" + username));
        return new UserDetailsImpl(user);
    }
}
