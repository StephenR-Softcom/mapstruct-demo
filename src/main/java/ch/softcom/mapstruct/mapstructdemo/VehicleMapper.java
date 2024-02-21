package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Vehicle;
import ch.softcom.mapstruct.mapstructdemo.data.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

// NOTE: MapStruct has options to map null to empty collection - good practise. Nobody likes null collections!
@Mapper(
        uses = PassengerMapper.class,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface VehicleMapper {

    // Nothing needs to be specified - all the fields have the same names and are auto-mapped
    VehicleDto toDto(Vehicle vehicle);

}
