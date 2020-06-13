package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Krutika Patil
 * @since : 6/12/2020, Fri
 **/
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
