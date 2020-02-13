package com.imbookings.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.imbookings.repository.SiteUserRepository;

@Component
public class SiteUserDetails implements UserDetailsService {

	@Autowired
    private SiteUserRepository siteUserRepository;


    public SiteUserDetails(SiteUserRepository siteUserRepository) {
        this.siteUserRepository = siteUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return siteUserRepository.findByName(name)
                .map(user -> new User(user.getName(), user.getPassword(), user.isEnabled(),
                        user.isEnabled(), user.isEnabled(), user.isEnabled(),
                        AuthorityUtils.createAuthorityList("USER")
                ))
                .orElseThrow(() -> new UsernameNotFoundException("can't find"));
    }
}
