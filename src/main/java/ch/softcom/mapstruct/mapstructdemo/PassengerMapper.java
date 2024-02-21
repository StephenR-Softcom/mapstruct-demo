package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Passenger;
import ch.softcom.mapstruct.mapstructdemo.data.PassengerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PassengerMapper {

    // NOTE: These fields must be mapped explicitly, because the names are different
    @Mapping(target = "first", source = "firstName")
    @Mapping(target = "last", source = "lastName")
    PassengerDto toDto(Passenger passenger);

    // NOTE: MapStruct can generate a reverse mapping by itself using this annotation. Be careful with fields missing on one side.
    @InheritInverseConfiguration
    Passenger fromDto(PassengerDto passengerDto);

}
