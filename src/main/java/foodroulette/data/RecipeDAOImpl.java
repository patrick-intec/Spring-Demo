package foodroulette.data;

import foodroulette.model.Recipe;

import java.sql.*;

public class RecipeDAOImpl implements RecipeDAO {
    private Connection connection;

    public RecipeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int[] getIDs() throws SQLException {
        String sqlString = "SELECT id FROM recipe";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sqlString);

        rs.last();
        int idCount = rs.getRow();

        int[] result = new int[idCount];
        while (rs.previous()) {
            result[--idCount] = rs.getInt(0);
        }

        return result;
    }

    @Override
    public Recipe getRecipe(int id) throws SQLException {
        String sql = "SELECT * FROM Recipe WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Recipe result = new Recipe();

        while (rs.next()) {
            // parse resultset
        }
        return result;
    }


}
