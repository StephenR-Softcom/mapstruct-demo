package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Vehicle;
import ch.softcom.mapstruct.mapstructdemo.data.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;

// NOTE: MapStruct has options to map null to empty collection - good practise. Nobody likes null collections!
@MapperConfig(nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)

//@Mapper(uses = PassengerMapper.class)
@Mapper
public interface VehicleMapper {

    // TODO add mapping for the passenger list

    // Nothing needs to be specified - all the fields have the same names and are auto-mapped
    VehicleDto toDto(Vehicle vehicle);

}
