package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author : Krutika Patil
 * @since : 6/12/2020, Fri
 **/
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}
