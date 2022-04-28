package org.keepcode.controller;

import org.keepcode.dto.SubscriberAuthDTO;
import org.keepcode.dto.SubscriberDTO;
import org.keepcode.entity.Subscriber;
import org.keepcode.exception.security.InvalidPasswordOrLoginException;
import org.keepcode.security.JwtTokenProvider;
import org.keepcode.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final SubscriberService subscriberService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, SubscriberService subscriberService,
                                        JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.subscriberService = subscriberService;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Valid @RequestBody SubscriberAuthDTO subscriberAuthDTO) {
        SubscriberDTO user = subscriberService.save(subscriberAuthDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody SubscriberAuthDTO subscriberAuthDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(subscriberAuthDTO.getEmail(), subscriberAuthDTO.getPassword()));
            Subscriber subscriber = subscriberService.getByEmail(subscriberAuthDTO.getEmail());
            String token = jwtTokenProvider.createToken(subscriber.getEmail(), subscriber.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("login", subscriber.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException exception) {
            throw new InvalidPasswordOrLoginException();
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
