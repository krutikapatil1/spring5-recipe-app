package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Category;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
public class RecipeToRecipeCommandConverterTest extends TestCase {

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
    RecipeToRecipeCommandConverter recipeToRecipeCommandConverter;

    public void setUp() throws Exception {
        super.setUp();
        recipeToRecipeCommandConverter = new RecipeToRecipeCommandConverter(new IngredientToIngredientCommandConverter(new UnitOfMeasureToUnitOfMeasureCommandConverter()), new CategoryToCategoryCommandConverter(), new NotesToNotesCommandConverter());
    }

    @Test
    public void test_Null() {
        assertNull(recipeToRecipeCommandConverter.convert(null));
    }

    @Test
    public void test_EmptyObj() {
        assertNotNull(recipeToRecipeCommandConverter.convert(new Recipe()));
    }

    @Test
    public void testConvert() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setDescription(DESCRIPTION);
        recipe.setPrepTime(PREPTIME);
        recipe.setCookTime(COOKTIME);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);
        recipe.setDirections(DIRECTIONS);
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(INGREDIENT_ID_1);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGREDIENT_ID_2);
        recipe.getIngredients().add(ingredient1);
        recipe.getIngredients().add(ingredient2);
        Category category1 = new Category();
        category1.setId(CAT_ID_1);
        Category category2 = new Category();
        category2.setId(CAT_ID_2);
        recipe.getCategories().add(category1);
        recipe.getCategories().add(category2);
        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);

        //when
        RecipeCommand recipeCommand = recipeToRecipeCommandConverter.convert(recipe);

        //then
        assertNotNull(recipeCommand);
        assertNotNull(recipeCommand.getIngredients());
        assertNotNull(recipeCommand.getCategories());
        assertNotNull(recipeCommand.getNotes());
        assertEquals(ID, recipeCommand.getId());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(PREPTIME, recipeCommand.getPrepTime());
        assertEquals(COOKTIME, recipeCommand.getCookTime());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(2, recipeCommand.getIngredients().size());
        assertEquals(2, recipeCommand.getCategories().size());
        assertEquals(NOTES_ID, recipeCommand.getNotes().getId());
    }
}