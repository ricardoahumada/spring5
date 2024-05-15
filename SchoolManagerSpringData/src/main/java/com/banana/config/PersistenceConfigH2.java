package com.banana.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryH2",
        basePackages = {"com.banana.persistence.school"},
        transactionManagerRef = "transactionManagerH2"
)
public class PersistenceConfigH2 {
    @Autowired
    private Environment env;

    @Bean(name = "transactionManagerH2")
    public PlatformTransactionManager transactionManagerH2() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryH2().getObject());
        return transactionManager;
    }

    @Bean
    DataSource schoolDataSourceH2() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(env.getProperty("h2.datasource.url"));

        ds.setDriverClassName(env.getProperty("h2.datasource.driver.class"));
        ds.setUsername(env.getProperty("h2.datasource.username"));
        ds.setPassword(env.getProperty("h2.datasource.password"));

        return ds;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setShowSql(true);
        va.setGenerateDdl(true);

        return va;
    }

    @Bean(name = "entityManagerFactoryH2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryH2() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName("school-h2");

        em.setDataSource(schoolDataSourceH2());
        em.setPackagesToScan("com.banana.models");
        em.setJpaVendorAdapter(vendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("h2.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("h2.jpa.hibernate.ddl-auto"));
        return properties;
    }

}