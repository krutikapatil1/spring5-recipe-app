package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.NotesCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Category;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class RecipeCommandToRecipeConverterTest extends TestCase {

    private static final Long ID = 1L;
    private static final String DESCRIPTION = "Description";
    private static final Integer PREPTIME = 10;
    private static final Integer COOKTIME = 20;
    private static final Integer SERVINGS = 2;
    private static final String SOURCE = "Simply Recipes";
    private static final String URL = "www.simplyrecipes.com";
    private static final String DIRECTIONS = "Directions";
    private static final Long INGREDIENT_ID_1 = 1L;
    private static final Long INGREDIENT_ID_2 = 2L;
    private static final Long CAT_ID_1 = 3L;
    private static final Long CAT_ID_2 = 4L;
    private static final Long NOTES_ID = 5L;
    RecipeCommandToRecipeConverter recipeCommandToRecipeConverter;

    public void setUp() throws Exception {
        super.setUp();
        recipeCommandToRecipeConverter = new RecipeCommandToRecipeConverter(new IngredientCommandToIngredientConverter(new UnitOfMeasureCommandToUnitOfMeasureConverter()), new CategoryCommandToCategoryConverter(), new NotesCommandToNotesConverter());
    }

    @Test
    public void test_Null() {
        assertNull(recipeCommandToRecipeConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(recipeCommandToRecipeConverter.convert(new RecipeCommand()));
    }

    @Test
    public void testConvert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setPrepTime(PREPTIME);
        recipeCommand.setCookTime(COOKTIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setDirections(DIRECTIONS);
        IngredientCommand ingredientCommand1 = new IngredientCommand();
        ingredientCommand1.setId(INGREDIENT_ID_1);
        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGREDIENT_ID_2);
        recipeCommand.getIngredients().add(ingredientCommand1);
        recipeCommand.getIngredients().add(ingredientCommand2);
        CategoryCommand categoryCommand1 = new CategoryCommand();
        categoryCommand1.setId(CAT_ID_1);
        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CAT_ID_2);
        recipeCommand.getCategories().add(categoryCommand1);
        recipeCommand.getCategories().add(categoryCommand2);
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);
        recipeCommand.setNotes(notesCommand);

        //when
        Recipe recipe = recipeCommandToRecipeConverter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertNotNull(recipe.getIngredients());
        assertNotNull(recipe.getCategories());
        assertNotNull(recipe.getNotes());
        assertEquals(ID, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREPTIME, recipe.getPrepTime());
        assertEquals(COOKTIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(2, recipe.getIngredients().size());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
    }
}