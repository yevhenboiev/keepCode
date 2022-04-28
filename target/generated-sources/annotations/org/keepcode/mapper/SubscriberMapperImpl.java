package org.keepcode.mapper;

import javax.annotation.Generated;
import org.keepcode.dto.SubscriberAuthDTO;
import org.keepcode.dto.SubscriberDTO;
import org.keepcode.entity.Subscriber;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T16:20:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class SubscriberMapperImpl implements SubscriberMapper {

    @Override
    public Subscriber toEntity(SubscriberDTO subscriberDto) {
        if ( subscriberDto == null ) {
            return null;
        }

        Subscriber subscriber = new Subscriber();

        subscriber.setId( subscriberDto.getId() );
        subscriber.setEmail( subscriberDto.getEmail() );
        subscriber.setPassword( subscriberDto.getPassword() );
        subscriber.setRole( subscriberDto.getRole() );
        subscriber.setCreationDate( subscriberDto.getCreationDate() );

        return subscriber;
    }

    @Override
    public Subscriber toEntity(SubscriberAuthDTO subscriberAuthDTO) {
        if ( subscriberAuthDTO == null ) {
            return null;
        }

        Subscriber subscriber = new Subscriber();

        subscriber.setEmail( subscriberAuthDTO.getEmail() );
        subscriber.setPassword( subscriberAuthDTO.getPassword() );

        return subscriber;
    }

    @Override
    public SubscriberDTO toDto(Subscriber subscriber) {
        if ( subscriber == null ) {
            return null;
        }

        SubscriberDTO subscriberDTO = new SubscriberDTO();

        subscriberDTO.setId( subscriber.getId() );
        subscriberDTO.setEmail( subscriber.getEmail() );
        subscriberDTO.setPassword( subscriber.getPassword() );
        subscriberDTO.setRole( subscriber.getRole() );
        subscriberDTO.setCreationDate( subscriber.getCreationDate() );

        return subscriberDTO;
    }
}
