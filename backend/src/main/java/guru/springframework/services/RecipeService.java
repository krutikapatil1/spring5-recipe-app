package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/7/2020, Sun
 **/
public interface RecipeService {
    Set<Recipe> getRecipes();
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
