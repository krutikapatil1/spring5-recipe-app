package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class IngredientToIngredientCommandConverterTest extends TestCase {

    private final static Long ID = 1L;
    private final static BigDecimal AMOUNT = new BigDecimal(2);
    private final static String DESCRIPTION = "Description";
    private final static Long UOM_ID = 2L;
    IngredientToIngredientCommandConverter ingredientToIngredientCommandConverter;

    public void setUp() throws Exception {
        super.setUp();
        ingredientToIngredientCommandConverter = new IngredientToIngredientCommandConverter(new UnitOfMeasureToUnitOfMeasureCommandConverter());
    }

    @Test
    public void test_Null() {
        assertNull(ingredientToIngredientCommandConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(ingredientToIngredientCommandConverter.convert(new Ingredient()));
    }

    @Test
    public void testConvert() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        //when
        IngredientCommand ingredientCommand = ingredientToIngredientCommandConverter.convert(ingredient);

        //then
        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUom());
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());
    }

    @Test
    public void testConvert_NullUOM() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        //when
        IngredientCommand ingredientCommand = ingredientToIngredientCommandConverter.convert(ingredient);

        //then
        assertNotNull(ingredientCommand);
        assertNull(ingredientCommand.getUom());
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
    }
}