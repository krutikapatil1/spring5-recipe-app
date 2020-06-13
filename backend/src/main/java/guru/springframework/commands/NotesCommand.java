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
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}
