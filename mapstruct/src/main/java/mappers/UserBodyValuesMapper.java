package mappers;

import annotations.PoundToKilogramMapper;
import model.bodyvalues.UserBodyImperialValuesDTO;
import model.bodyvalues.UserBodyValues;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserBodyValuesMapper {
    double INCH_TO_METRIC_CHANGE_NUMBER = 2.54;

    UserBodyValuesMapper INSTANCE = Mappers.getMapper(UserBodyValuesMapper.class);

    @Mapping(source = "inch", target = "centimeter", qualifiedByName = "inchToCentimeter")
    @Mapping(source = "pound", target = "kilogram", qualifiedBy = PoundToKilogramMapper.class)
    public UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);

    @Named("inchToCentimeter")
    public static double inchToCentimeter(int inch) {
        return inch * INCH_TO_METRIC_CHANGE_NUMBER;
    }

    @PoundToKilogramMapper
    public static double poundToKilogram(int pound) {
        return pound * 0.4535;
    }
}