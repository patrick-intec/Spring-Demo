package foodroulette.service;

import foodroulette.model.Recipe;

import java.sql.SQLException;

public interface RecipeService {
    /**
     * Fetches a random recipe from the database(via the DAO)
     * @return a random recipe from the database
     */
    Recipe getRandomRecipe() throws YourDBisEmptyAFException, SQLException;

    void init();

    void cleanUp();

}
