package ch.softcom.mapstruct.mapstructdemo.data;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Vehicle {

    String model;
    
    // MapStruct can map enums to enums, or to string
    VehicleType type;

    int maxPassengers;

    List<Passenger> passengers;

}
