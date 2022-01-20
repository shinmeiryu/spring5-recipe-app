package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
  Optional<Recipe> findByDescription(String description);
}
