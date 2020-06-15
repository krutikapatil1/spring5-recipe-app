package guru.springframework.controller;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/7/2020, Sun
 **/
@Slf4j
@RestController
public class RecipesController {

    private final RecipeServiceImpl recipeServiceImpl;

    public RecipesController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping(value = "getRecipes", method = RequestMethod.GET)
    public Set<Recipe> getRecipes() {
        log.debug("Inside getRecipes");
        return recipeServiceImpl.getRecipes();
    }

    @RequestMapping(value = "saveRecipe", method = RequestMethod.POST)
    public RecipeCommand saveRecipe(@RequestBody RecipeCommand recipeCommand) {
        System.out.println(recipeCommand);
        RecipeCommand savedRecipeCommand = recipeServiceImpl.saveRecipeCommand(recipeCommand);
        return savedRecipeCommand;
    }

    @DeleteMapping(value = "deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeServiceImpl.deleteRecipeById(Long.parseLong(id));
    }
}
