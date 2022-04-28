package org.keepcode.service;

import org.keepcode.dto.SubscriberAuthDTO;
import org.keepcode.dto.SubscriberDTO;
import org.keepcode.entity.Subscriber;

public interface SubscriberService {
    SubscriberDTO save(SubscriberAuthDTO subscriberRegistrationDto);

    Subscriber getByEmail(String email);

    Subscriber getById(Long subscriber_id);
}
