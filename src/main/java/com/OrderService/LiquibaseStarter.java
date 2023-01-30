package com.OrderService;


import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class LiquibaseStarter {


    @Value("${liquibase.change-log}")
    String changeLogPath;

    DataSource dataSource;


    public LiquibaseStarter(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    public void startLiquibase() throws LiquibaseException, SQLException {

        java.sql.Connection connection = dataSource.getConnection();

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

        try (Liquibase liquibase = new liquibase.Liquibase(changeLogPath, new ClassLoaderResourceAccessor(), database)) {
            liquibase.update(new Contexts(), new LabelExpression());
        }
    }


}
