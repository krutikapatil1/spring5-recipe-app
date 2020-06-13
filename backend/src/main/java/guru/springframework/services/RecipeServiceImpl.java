package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipeConverter;
import guru.springframework.converters.RecipeToRecipeCommandConverter;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/7/2020, Sun
 **/
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommandConverter recipeToRecipeCommandConverter;
    private final RecipeCommandToRecipeConverter recipeCommandToRecipeConverter;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipeConverter recipeCommandToRecipeConverter,
                             RecipeToRecipeCommandConverter recipeToRecipeCommandConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipeConverter = recipeCommandToRecipeConverter;
        this.recipeToRecipeCommandConverter = recipeToRecipeCommandConverter;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In getRecipes");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipeConverter.convert(recipeCommand);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe ID: " + savedRecipe.getId());
        return recipeToRecipeCommandConverter.convert(savedRecipe);
    }
}
