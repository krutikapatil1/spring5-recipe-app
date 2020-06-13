package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class CategoryToCategoryCommandConverterTest extends TestCase {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "Description";
    CategoryToCategoryCommandConverter categoryToCategoryCommandConverter;

    public void setUp() throws Exception {
        super.setUp();
        categoryToCategoryCommandConverter = new CategoryToCategoryCommandConverter();
    }

    @Test
    public void test_Null() {
        assertNull(categoryToCategoryCommandConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(categoryToCategoryCommandConverter.convert(new Category()));
    }

    @Test
    public void testConvert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = categoryToCategoryCommandConverter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}