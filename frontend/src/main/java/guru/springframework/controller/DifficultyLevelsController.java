package guru.springframework.controller;

import guru.springframework.domain.Difficulty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Krutika Patil
 * @since : 6/15/2020, Mon
 **/
@RestController
public class DifficultyLevelsController {

    @RequestMapping(value = "/getDifficultyLevels", method = RequestMethod.GET)
    public Difficulty[] getDifficultyLevels() {
        return Difficulty.values();
    }
}
