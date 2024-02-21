package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Passenger;
import ch.softcom.mapstruct.mapstructdemo.data.Vehicle;
import ch.softcom.mapstruct.mapstructdemo.data.VehicleDto;
import ch.softcom.mapstruct.mapstructdemo.data.VehicleType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VehicleMapperTest {

    @Mock
    private PassengerMapper passengerMapper;

    @InjectMocks
    private VehicleMapperImpl mapper;

    @Test
    void testToDtoWithoutPassengers() {
        // given
        final Vehicle vehicle = Vehicle.builder()
                .model("Bombardier 1337")
                .type(VehicleType.TRAIN)
                .maxPassengers(120)
                .build();

        // when
        final VehicleDto dto = mapper.toDto(vehicle);

        // then
        then(dto).hasNoNullFieldsOrPropertiesExcept("passengers");
        then(dto.getModel()).isEqualTo(vehicle.getModel());
        then(dto.getType()).isEqualTo(vehicle.getType().name());
        then(dto.getPassengers())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void testPassengersAreMapped() {
        // given
        final Vehicle vehicle = Vehicle.builder()
                .model("Fiat 500")
                .type(VehicleType.CAR)
                .maxPassengers(5)
                .passengers(Arrays.asList(
                        Passenger.builder().firstName("Albert").lastName("McMillan").build(),
                        Passenger.builder().firstName("Jean").lastName("Meyer").build()
                ))
                .build();

        // when
        final VehicleDto dto = mapper.toDto(vehicle);

        // then
        assertThat(dto).hasNoNullFieldsOrProperties();
        ArgumentCaptor<Passenger> passengerArgumentCaptor = ArgumentCaptor.forClass(Passenger.class);
        verify(passengerMapper, times(2)).toDto(passengerArgumentCaptor.capture());
        assertThat(passengerArgumentCaptor.getAllValues()).isEqualTo(vehicle.getPassengers());
    }

}