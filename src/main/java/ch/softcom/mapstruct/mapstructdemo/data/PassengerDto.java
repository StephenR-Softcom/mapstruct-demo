package ch.softcom.mapstruct.mapstructdemo.data;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PassengerDto {
    
    String first;
    String last;
}
