package ch.softcom.mapstruct.mapstructdemo;

import ch.softcom.mapstruct.mapstructdemo.data.Passenger;
import ch.softcom.mapstruct.mapstructdemo.data.PassengerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class PassengerMapperTest {

    @InjectMocks
    private PassengerMapperImpl mapper;

    @Test
    void testToDto() {
        // given
        final Passenger passenger = Passenger.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .build();

        // when
        final PassengerDto dto = mapper.toDto(passenger);

        // then
        then(dto).hasNoNullFieldsOrProperties();
        then(dto.getFirst()).isEqualTo(passenger.getFirstName());
        then(dto.getLast()).isEqualTo(passenger.getLastName());
    }
}