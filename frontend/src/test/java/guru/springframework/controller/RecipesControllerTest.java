package guru.springframework.controller;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author : Krutika Patil
 * @since : 6/9/2020, Tue
 **/
public class RecipesControllerTest extends TestCase {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void testGetRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        Mockito.when(recipeRepository.findAll()).thenReturn(recipes);
        assertEquals(1, recipeService.getRecipes().size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}