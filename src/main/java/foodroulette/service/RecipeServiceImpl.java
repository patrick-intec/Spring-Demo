package foodroulette.service;

import foodroulette.data.RecipeDAO;
import foodroulette.model.Recipe;

import java.sql.SQLException;
import java.util.Random;

public class RecipeServiceImpl implements RecipeService {
    private RecipeDAO recipeDAO;

    public RecipeServiceImpl(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public void init() {
        // Stuff we want to do when the bean is created
    }

    public void cleanUp() {
        // Stuff we want to do when the bean is destroyed
    }

    @Override
    public Recipe getRandomRecipe() throws YourDBisEmptyAFException, SQLException {
        int[] availableIDs = recipeDAO.getIDs();

        if (availableIDs.length == 0) try {
            throw new YourDBisEmptyAFException();
        } catch (YourDBisEmptyAFException e) {
            // createLogMessageForAdmin(e);
            throw e;
        }
        Random random = new Random();
        int randomID = availableIDs[random.nextInt(availableIDs.length)];
        return recipeDAO.getRecipe(randomID);
    }
}
