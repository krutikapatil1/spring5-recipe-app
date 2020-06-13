package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class CategoryCommandToCategoryConverterTest extends TestCase {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "Description";
    CategoryCommandToCategoryConverter categoryCommandToCategoryConverter;

    public void setUp() throws Exception {
        super.setUp();
        categoryCommandToCategoryConverter = new CategoryCommandToCategoryConverter();
    }

    @Test
    public void test_Null() {
        assertNull(categoryCommandToCategoryConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(categoryCommandToCategoryConverter.convert(new CategoryCommand()));
    }

    public void testConvert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = categoryCommandToCategoryConverter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}