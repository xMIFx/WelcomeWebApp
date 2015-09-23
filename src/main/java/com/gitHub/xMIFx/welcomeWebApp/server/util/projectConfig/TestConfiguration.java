package com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig;

import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserServiceImpl;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by bukatinvv on 16.09.2015.
 */
@Configuration
@PropertySource("classpath:jdbcForTest.properties")
@EnableTransactionManagement
@ComponentScan(value = {"com.gitHub.xMIFx.welcomeWebApp.server.repositories"
        , "com.gitHub.xMIFx.welcomeWebApp.server.services"})
public class TestConfiguration {
    @Autowired
    Environment env;

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setProperties(c3p0Properties());
        dataSource.setDriverClass(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFact() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("com.gitHub.xMIFx.welcomeWebApp.server.domain");
        sessionFactory.setDataSource(dataSource());

        return sessionFactory;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFact) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFact);
        return transactionManager;
    }

    /*Properties*/
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.connection.CharSet", env.getRequiredProperty("hibernate.connection.CharSet"));
        properties.put("hibernate.connection.characterEncoding", env.getRequiredProperty("hibernate.connection.characterEncoding"));
        properties.put("hibernate.connection.useUnicode", env.getRequiredProperty("hibernate.connection.useUnicode"));
        properties.put("hibernate.hbm2ddl.import_files", "insert_h2.sql");
        return properties;
    }

    private Properties c3p0Properties() {
        Properties properties = new Properties();
        properties.put("hibernate.c3p0.min_size", env.getRequiredProperty("c3p0.min_size"));
        properties.put("hibernate.c3p0.max_size", env.getRequiredProperty("c3p0.max_size"));
        properties.put("hibernate.c3p0.timeout", env.getRequiredProperty("c3p0.timeout"));
        properties.put("hibernate.c3p0.max_statements", env.getRequiredProperty("c3p0.max_statements"));
        properties.put("hibernate.c3p0.idle_test_period", env.getRequiredProperty("c3p0.idle_test_period"));
        return properties;
    }
}
