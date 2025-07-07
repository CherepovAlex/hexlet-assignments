package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.List;

// BEGIN

@Mapper(
        uses = { JsonNullableMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public abstract class CarMapper {
    public abstract Car map(CarCreateDTO dto); // create
    public abstract CarDTO map(Car model); // show
    public abstract List<CarDTO> map(List<Car> cars);
    public abstract void update(CarUpdateDTO dto, @MappingTarget Car car); // update

}
// END
