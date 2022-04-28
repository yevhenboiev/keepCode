package org.keepcode.mapper;

import org.keepcode.dto.SubscriberAuthDTO;
import org.keepcode.dto.SubscriberDTO;
import org.keepcode.entity.Subscriber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {
    Subscriber toEntity(SubscriberDTO subscriberDto);

    Subscriber toEntity(SubscriberAuthDTO subscriberAuthDTO);

    SubscriberDTO toDto(Subscriber subscriber);
}
