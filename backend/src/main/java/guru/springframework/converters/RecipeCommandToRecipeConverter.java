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
public class RecipeCommandToRecipeConverter implements Converter<RecipeCommand, Recipe> {

    private final IngredientCommandToIngredientConverter ingredientCommandToIngredientConverter;
    private final CategoryCommandToCategoryConverter categoryCommandToCategoryConverter;
    private final NotesCommandToNotesConverter notesCommandToNotesConverter;

    public RecipeCommandToRecipeConverter(IngredientCommandToIngredientConverter ingredientCommandToIngredientConverter, CategoryCommandToCategoryConverter categoryCommandToCategoryConverter, NotesCommandToNotesConverter notesCommandToNotesConverter) {
        this.ingredientCommandToIngredientConverter = ingredientCommandToIngredientConverter;
        this.categoryCommandToCategoryConverter = categoryCommandToCategoryConverter;
        this.notesCommandToNotesConverter = notesCommandToNotesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDirections(source.getDirections());
        recipe.setNotes(notesCommandToNotesConverter.convert(source.getNotes()));
        recipe.setDifficulty(source.getDifficulty());
        recipe.setImage(source.getImage());

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach(ingredientCommand -> {
                recipe.getIngredients().add(ingredientCommandToIngredientConverter.convert(ingredientCommand));
            });
        }

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(categoryCommand -> {
                recipe.getCategories().add(categoryCommandToCategoryConverter.convert(categoryCommand));
            });
        }

        return recipe;
    }
}
