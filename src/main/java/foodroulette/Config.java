package foodroulette;


import foodroulette.data.RecipeDAO;
import foodroulette.data.RecipeDAOImpl;
import foodroulette.service.RecipeService;
import foodroulette.service.RecipeServiceImpl;
import foodroulette.view.UserView;
import foodroulette.view.UserViewImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class Config {
    @Bean
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("");
    }

    @Bean
    @Scope("prototype")
    public RecipeDAO recipeDAO(Connection connection) {
        return new RecipeDAOImpl(connection);
    }

    @Bean(initMethod = "init", destroyMethod = "cleanUp")
    @Primary
    public RecipeService recipeService(RecipeDAO recipeDAO) {
        return new RecipeServiceImpl(recipeDAO);
    }

    @Bean(name = "anotherService")
    public RecipeService anotherService(RecipeDAO recipeDAO) {
        return new RecipeServiceImpl(recipeDAO);
    }

    @Bean
    public UserView createUserView(@Qualifier("anotherService") RecipeService service) {
        return new UserViewImpl(service);
    }
}
