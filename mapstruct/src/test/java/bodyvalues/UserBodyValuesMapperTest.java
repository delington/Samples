package bodyvalues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserBodyValuesMapperTest {

    @Test
    public void shouldExchangeValues(){
        UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
        dto.setInch(10);

        UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);

        assertNotNull(obj);
        assertEquals(25.4, obj.getCentimeter(), 0);
    }
}