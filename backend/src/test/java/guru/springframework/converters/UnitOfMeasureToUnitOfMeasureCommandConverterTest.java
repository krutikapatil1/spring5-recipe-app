package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class UnitOfMeasureToUnitOfMeasureCommandConverterTest extends TestCase {

    private static final Long ID = 1L;
    private static final String DESCRIPTION = "Description";
    UnitOfMeasureToUnitOfMeasureCommandConverter unitOfMeasureToUnitOfMeasureCommandConverter;

    public void setUp() throws Exception {
        super.setUp();
        unitOfMeasureToUnitOfMeasureCommandConverter = new UnitOfMeasureToUnitOfMeasureCommandConverter();
    }

    @Test
    public void test_Null() {
        assertNull(unitOfMeasureToUnitOfMeasureCommandConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(unitOfMeasureToUnitOfMeasureCommandConverter.convert(new UnitOfMeasure()));
    }

    @Test
    public void testConvert() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommandConverter.convert(unitOfMeasure);

        //then
        assertEquals(ID, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}