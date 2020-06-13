package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
@Component
public class RecipeToRecipeCommandConverter implements Converter<Recipe, RecipeCommand> {

    private final IngredientToIngredientCommandConverter ingredientToIngredientCommandConverter;
    private final CategoryToCategoryCommandConverter categoryToCategoryCommandConverter;
    private final NotesToNotesCommandConverter notesToNotesCommandConverter;

    public RecipeToRecipeCommandConverter(IngredientToIngredientCommandConverter ingredientToIngredientCommandConverter, CategoryToCategoryCommandConverter categoryToCategoryCommandConverter, NotesToNotesCommandConverter notesToNotesCommandConverter) {
        this.ingredientToIngredientCommandConverter = ingredientToIngredientCommandConverter;
        this.categoryToCategoryCommandConverter = categoryToCategoryCommandConverter;
        this.notesToNotesCommandConverter = notesToNotesCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setNotes(notesToNotesCommandConverter.convert(source.getNotes()));

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach(ingredient -> {
                recipeCommand.getIngredients().add(ingredientToIngredientCommandConverter.convert(ingredient));
            });
        }

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(category -> {
                recipeCommand.getCategories().add(categoryToCategoryCommandConverter.convert(category));
            });
        }

        return recipeCommand;
    }
}
