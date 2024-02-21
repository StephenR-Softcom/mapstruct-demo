package ch.softcom.mapstruct.mapstructdemo.data;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class VehicleDto {

    String model;

    // This is a string - the entity uses an Enum
    String type;

    // NOTE: maxPassengers is deliberately missing. MapStruct can deal with this.

    @NonNull List<PassengerDto> passengers;

}
