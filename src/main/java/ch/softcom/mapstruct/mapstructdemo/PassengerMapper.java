package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Passenger;
import ch.softcom.mapstruct.mapstructdemo.data.PassengerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PassengerMapper {

    // TODO add mappings - see the IDE warning

    @Mapping(target = "first", source = "firstName")
    @Mapping(target = "last", source = "lastName")
    PassengerDto toDto(Passenger passenger);

}
