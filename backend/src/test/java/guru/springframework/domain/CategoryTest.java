package guru.springframework.domain;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/9/2020, Tue
 **/
public class CategoryTest extends TestCase {

    Category category;

    public void setUp() throws Exception {
        super.setUp();
        category = new Category();
    }

    public void testGetId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    public void testGetDescription() {
        String description = "Test";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }

    public void testGetRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        category.setRecipes(recipes);
        assertEquals(1, category.getRecipes().size());
    }
}