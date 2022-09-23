package mapper;

import mappers.UserBodyValuesMapper;
import model.bodyvalues.UserBodyImperialValuesDTO;
import model.bodyvalues.UserBodyValues;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserBodyValuesMapperTest {

    @Test
    public void shouldExchangeValues(){
        UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
        dto.setInch(10);

        UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);

        assertNotNull(obj);
        assertEquals(25.4, obj.getCentimeter(), 0);
    }

    @Test
    public void shouldExchangeValuesWithCustomAnnotation(){
        UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
        dto.setPound(100);

        UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);

        assertNotNull(obj);
        assertEquals(45.35, obj.getKilogram(), 0);
    }
}