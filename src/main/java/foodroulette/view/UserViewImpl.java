package foodroulette.view;

import foodroulette.model.Recipe;
import foodroulette.service.RecipeService;
import foodroulette.service.YourDBisEmptyAFException;

import java.sql.SQLException;

public class UserViewImpl implements UserView {
    private RecipeService service;

    public UserViewImpl(RecipeService service) {
        this.service = service;
    }

    @Override
    public void getRecipe() throws SQLException, YourDBisEmptyAFException {
        System.out.println("Getting a recipe for you...");
        Recipe recipe = service.getRandomRecipe();
        showRecipe(recipe);
    }

    @Override
    public void resetViewAndGetRecipe() throws SQLException, YourDBisEmptyAFException {
        resetView();
        getRecipe();
    }

    private void showRecipe(Recipe recipe) {
        System.out.println(recipe.toString());
    }

    private void resetView() {
        System.out.println("Resetting the view");
    }
}
