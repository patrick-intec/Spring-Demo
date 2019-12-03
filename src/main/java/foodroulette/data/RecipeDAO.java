package foodroulette.data;

import foodroulette.model.Recipe;

import java.sql.SQLException;

public interface RecipeDAO {
    int[] getIDs() throws SQLException;

    Recipe getRecipe(int id) throws SQLException;
}
