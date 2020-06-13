package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author : Krutika Patil
 * @since : 6/13/2020, Sat
 **/
@Component
public class IngredientCommandToIngredientConverter implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasureConverter unitOfMeasureCommandToUnitOfMeasureConverter;

    public IngredientCommandToIngredientConverter(UnitOfMeasureCommandToUnitOfMeasureConverter unitOfMeasureCommandToUnitOfMeasureConverter) {
        this.unitOfMeasureCommandToUnitOfMeasureConverter = unitOfMeasureCommandToUnitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(unitOfMeasureCommandToUnitOfMeasureConverter.convert(source.getUom()));

        return ingredient;
    }
}
