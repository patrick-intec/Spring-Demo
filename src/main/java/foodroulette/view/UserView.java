package foodroulette.view;


import foodroulette.service.YourDBisEmptyAFException;

import java.sql.SQLException;

public interface UserView {
    /**
     * We drukken op de knop (getRecipe button)
     * \=> haalt recept op van service
     * \=> Toon recept
     */
    void getRecipe() throws SQLException, YourDBisEmptyAFException;


    /**
     * We drukken op de knop (refresh button)
     * \=> Reset de user interface
     * \=> doGetRandomRecipe()
     */
    void resetViewAndGetRecipe() throws SQLException, YourDBisEmptyAFException;
}
