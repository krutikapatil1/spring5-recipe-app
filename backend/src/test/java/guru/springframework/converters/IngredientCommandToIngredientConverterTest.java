package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class IngredientCommandToIngredientConverterTest extends TestCase {

    private final static Long ID = 1L;
    private final static BigDecimal AMOUNT = new BigDecimal(2);
    private final static String DESCRIPTION = "Description";
    private final static Long UOM_ID = 2L;
    IngredientCommandToIngredientConverter ingredientCommandToIngredientConverter;


    public void setUp() throws Exception {
        super.setUp();
        ingredientCommandToIngredientConverter = new IngredientCommandToIngredientConverter(new UnitOfMeasureCommandToUnitOfMeasureConverter());
    }

    @Test
    public void test_Null() {
        assertNull(ingredientCommandToIngredientConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(ingredientCommandToIngredientConverter.convert(new IngredientCommand()));
    }

    @Test
    public void testConvert() {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        ingredientCommand.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = ingredientCommandToIngredientConverter.convert(ingredientCommand);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void testConvert_NullUOM() {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setDescription(DESCRIPTION);

        //when
        Ingredient ingredient = ingredientCommandToIngredientConverter.convert(ingredientCommand);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
    }
}