package guru.springframework.controller;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/7/2020, Sun
 **/
@RestController
public class RecipesController {

    private final RecipeServiceImpl recipeServiceImpl;

    public RecipesController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping(value = "getRecipes", method = RequestMethod.GET)
    public Set<Recipe> getRecipes() {
        return recipeServiceImpl.getRecipes();
    }

}
