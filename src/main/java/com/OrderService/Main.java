package com.OrderService;

import com.OrderService.Configuration.SpringConfiguration;
import liquibase.exception.LiquibaseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        LiquibaseStarter liquibaseStarter = context.getBean("liquibaseStarter", LiquibaseStarter.class);

        try {
            liquibaseStarter.startLiquibase();

        } catch ( SQLException | LiquibaseException exception) {
            exception.printStackTrace();
        }

    }
}
