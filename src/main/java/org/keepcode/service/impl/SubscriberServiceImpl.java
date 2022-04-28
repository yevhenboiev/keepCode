package org.keepcode.service.impl;

import lombok.RequiredArgsConstructor;
import org.keepcode.dto.SubscriberAuthDTO;
import org.keepcode.dto.SubscriberDTO;
import org.keepcode.entity.Subscriber;
import org.keepcode.entity.enums.Role;
import org.keepcode.exception.userException.ExistUserException;
import org.keepcode.exception.userException.NotExistUserException;
import org.keepcode.mapper.SubscriberMapper;
import org.keepcode.repository.SubscriberRepository;
import org.keepcode.service.ClientService;
import org.keepcode.service.SubscriberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

    private final PasswordEncoder passwordEncoder;
    private final SubscriberRepository subscriberRepository;
    private final SubscriberMapper subscriberMapper;
    private final ClientService clientService;

    @Transactional
    @Override
    public SubscriberDTO save(SubscriberAuthDTO subscriberAuthDto) {
        if (subscriberRepository.findByEmail(subscriberAuthDto.getEmail()).isPresent()) {
            throw new ExistUserException(subscriberAuthDto.getEmail());
        }
        Subscriber subscriber = subscriberMapper.toEntity(subscriberAuthDto);
        subscriber.setPassword(passwordEncoder.encode(subscriberAuthDto.getPassword()));
        subscriber.setRole(Role.USER);
        subscriber.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return subscriberMapper.toDto(subscriberRepository.save(subscriber));
    }

    @Override
    public Subscriber getByEmail(String email) {
        Optional<Subscriber> clientOptional = subscriberRepository.findByEmail(email);
        if (!clientOptional.isPresent()) {
            throw new NotExistUserException("Not found client by " + email);
        }
        return clientOptional.get();
    }

    @Override
    public Subscriber getById(Long subscriber_id) {
        Optional<Subscriber> subscriber = subscriberRepository.findById(subscriber_id);
        if(!subscriber.isPresent()) {
            throw new NotExistUserException("Not exist subscriber by id " + subscriber_id);
        }
        return subscriber.get();
    }
}
