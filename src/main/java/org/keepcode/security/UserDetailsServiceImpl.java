package org.keepcode.security;

import org.keepcode.entity.Subscriber;
import org.keepcode.exception.subscriberException.NotExistSubscriberException;
import org.keepcode.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public UserDetailsServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Subscriber subscriber = subscriberRepository.findByEmail(login)
                .orElseThrow(() -> new NotExistSubscriberException(login));
        return SecurityUser.clientToUserDetails(subscriber);
    }
}
