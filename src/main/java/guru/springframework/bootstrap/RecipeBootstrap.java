package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final CategoryRepository categoryRepository;
  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public RecipeBootstrap(CategoryRepository categoryRepository,
      RecipeRepository recipeRepository,
      UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  private List<Recipe> getRecipes() {
    List<Recipe> recipes = new ArrayList<>();

    //Get UOM
    Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
    if(!eachUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
    if(!tableSpoonUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    if(!teaspoonUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
    if(!pinchUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
    if(!cupUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
    if(!ounceUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
    if(!dashUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
    if(!pintUomOptional.isPresent()) {
      throw new RuntimeException("Expected UOM Not Found");
    }

    //Get optionals
    UnitOfMeasure each = eachUomOptional.get();
    UnitOfMeasure tablespoon = tableSpoonUomOptional.get();
    UnitOfMeasure teaspoon = teaspoonUomOptional.get();
    UnitOfMeasure pinch = pinchUomOptional.get();
    UnitOfMeasure ounce = ounceUomOptional.get();
    UnitOfMeasure cup = cupUomOptional.get();

    Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
    if(!americanCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not Found");
    }

    Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
    if(!italianCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not Found");
    }

    Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
    if(!mexicanCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not Found");
    }

    Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
    if(!fastFoodCategoryOptional.isPresent()) {
      throw new RuntimeException("Expected Category Not Found");
    }

    //Get categories
    Category americanCategory = americanCategoryOptional.get();
    Category italianCategory = italianCategoryOptional.get();
    Category mexicanCategory = mexicanCategoryOptional.get();
    Category fastFoodCategory = fastFoodCategoryOptional.get();

    //New recipe (source: https://www.bonappetit.com/recipe/bas-best-bolognese)
    Recipe bologneseRecipe = new Recipe();
    bologneseRecipe.setDescription("BA's Best Bolognese");
    bologneseRecipe.setPrepTime(30);
    bologneseRecipe.setCookTime(240);
    bologneseRecipe.setDifficulty(Difficulty.MODERATE);
    bologneseRecipe.setDirections("Step 1\n" +
        "Pulse onion, celery, and carrot in a food processor until very finely chopped. Transfer to a small bowl.\n" +
        "\n" +
        "Step 2\n" +
        "Heat oil in a Dutch oven or other large pot over medium. Break beef into small clumps (about 1½\") and add to pot; season lightly with salt. Cook, stirring occasionally but not breaking meat apart, until beef is lightly browned but not crisp, 6–8 minutes. It may be gray in spots (that’s okay!) and still a little pink in the center. Using a slotted spoon, transfer beef to a medium bowl.\n" +
        "\n" +
        "Step 3\n" +
        "Wipe out pot. Cook pancetta in pot over medium heat, stirring occasionally, until pancetta has released some of its fat and is crisp, 6–8 minutes. Add onion mixture to pot and cook, stirring occasionally, until vegetables are very soft and beginning to stick to surface, 6–8 minutes.\n" +
        "\n" +
        "Step 4\n" +
        "Return beef to pot and pour in wine. Reduce heat to medium-low and cook, smashing down on beef with a wooden spoon, until wine is evaporated, surface of pot is almost dry, and meat is finely ground, 12–15 minutes. (The meat should be reduced to what looks like little bits. It takes a bit of effort, but you can take breaks.) Add tomato paste, bay leaf, and nutmeg and cook, stirring occasionally and still pressing down on meat, until tomato paste is slightly darkened, about 5 minutes.\n" +
        "\n" +
        "Step 5\n" +
        "Pour stock and milk into pot; add a pinch of salt. Reduce heat to the lowest setting and cook, uncovered and stirring occasionally, until meat is very, very tender, 2–2½ hours. There shouldn’t be any rapid bubbles at this stage. Instead, the sauce should release the occasional small bubble or two. When finished, the sauce should have the texture of and look like a sloppy joe mixture. If the liquid reduces before the meat is completely tender, add an extra ½ cup stock and continue cooking. Discard bay leaf. Taste sauce and adjust seasoning with salt; keep warm.\n" +
        "\n" +
        "Step 6\n" +
        "Cook pasta in a large pot of boiling salted water. If using fresh pasta, cook about 3 minutes. If using dry, cook until very al dente, about 2 minutes less than package directions.\n" +
        "\n" +
        "Step 7\n" +
        "Using tongs, transfer pasta to pot with sauce. Add 1 cup pasta cooking liquid and ½ cup Parmesan. Increase heat to medium, bring to a simmer, and cook, tossing constantly, until pasta is al dente and liquid is slightly thickened, about 2 minutes.\n" +
        "\n" +
        "Step 8\n" +
        "Transfer pasta to a platter and top with more Parmesan.");

    Notes bologneseNotes = new Notes();
    bologneseNotes.setRecipeNotes("It doesn’t take a lot of ingredients (or a lot of money) to make a classic Bolognese recipe. What it does take, though, is patience for the sauce to achieve the ideal authentic texture. You’re going to go low and slow—it’ll take around 3 hours, but most of that cook time is hands-off. \n" +
        "\n" +
        "All products featured on Bon Appétit are independently selected by our editors. However, when you buy something through the retail links below, we earn an affiliate commission.");
    bologneseNotes.setRecipe(bologneseRecipe);
    bologneseRecipe.setNotes(bologneseNotes);

    bologneseRecipe.getIngredients().add(new Ingredient("medium onion", new BigDecimal(1), each, bologneseRecipe));
    bologneseRecipe.getIngredients().add(new Ingredient("celery stalk", new BigDecimal(1), each, bologneseRecipe));
    bologneseRecipe.getIngredients().add(new Ingredient("small carrot", new BigDecimal(1), each, bologneseRecipe));
    bologneseRecipe.getIngredients().add(new Ingredient("extra-virgin olive oil", new BigDecimal(3), tablespoon, bologneseRecipe));
    bologneseRecipe.getIngredients().add(new Ingredient("ground beef", new BigDecimal(3), cup, bologneseRecipe));
    bologneseRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(1), pinch, bologneseRecipe));
    //More ingredients to come...

    bologneseRecipe.getCategories().add(italianCategory);
    recipes.add(bologneseRecipe);

    return recipes;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    recipeRepository.saveAll(getRecipes());
  }
}
