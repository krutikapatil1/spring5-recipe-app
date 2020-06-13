package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class UnitOfMeasureCommandToUnitOfMeasureConverterTest extends TestCase {

    private static final Long ID = 1L;
    private static final String DESCRIPTION = "Description";
    UnitOfMeasureCommandToUnitOfMeasureConverter unitOfMeasureCommandToUnitOfMeasureConverter;

    public void setUp() throws Exception {
        super.setUp();
        unitOfMeasureCommandToUnitOfMeasureConverter = new UnitOfMeasureCommandToUnitOfMeasureConverter();
    }

    @Test
    public void test_Null() {
        assertNull(unitOfMeasureCommandToUnitOfMeasureConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(unitOfMeasureCommandToUnitOfMeasureConverter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void testConvert() {
        //given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID);
        unitOfMeasureCommand.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure unitOfMeasure = unitOfMeasureCommandToUnitOfMeasureConverter.convert(unitOfMeasureCommand);

        //then
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }
}