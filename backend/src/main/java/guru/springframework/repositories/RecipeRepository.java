package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Krutika Patil
 * @since : 6/7/2020, Sun
 **/
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
