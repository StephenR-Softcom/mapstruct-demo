package ch.softcom.mapstruct.mapstructdemo.data;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PassengerDto {
    
    // TODO map the fields manually, as field names do not match
    String first;
    String last;
}
