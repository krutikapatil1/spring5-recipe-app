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
public class IngredientToIngredientCommandConverter implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommandConverter unitOfMeasureToUnitOfMeasureCommandConverter;

    public IngredientToIngredientCommandConverter(UnitOfMeasureToUnitOfMeasureCommandConverter unitOfMeasureToUnitOfMeasureCommandConverter) {
        this.unitOfMeasureToUnitOfMeasureCommandConverter = unitOfMeasureToUnitOfMeasureCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUom(unitOfMeasureToUnitOfMeasureCommandConverter.convert(source.getUom()));

        return ingredientCommand;
    }
}
