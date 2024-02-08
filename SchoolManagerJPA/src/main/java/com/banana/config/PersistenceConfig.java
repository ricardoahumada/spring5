package com.banana.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
    @Autowired
    private Environment env;

    @Bean // JPA transaction manager
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(schoolEmf().getObject());
        return transactionManager;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    DataSource schoolDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(env.getProperty("schooldb.url"));

        ds.setDriverClassName(env.getProperty("schooldb.driverClassName"));
        ds.setUsername(env.getProperty("schooldb.dbUserName"));
        ds.setPassword(env.getProperty("schooldb.password"));

        return ds;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setShowSql(false);
        va.setGenerateDdl(true);

        return va;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean schoolEmf() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName(env.getProperty("schooldb.persistenceUnitName"));

        em.setDataSource(schoolDataSource());
        em.setPackagesToScan("com.banana.models");
        em.setJpaVendorAdapter(vendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("schooldb.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("schooldb.hbm2ddl"));
        return properties;
    }

}