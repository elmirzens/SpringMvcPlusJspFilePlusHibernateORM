package spring.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("spring")
@PropertySource("classpath:myapp.properties")
public class AppConfig implements WebMvcConfigurer {

    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String username;
    @Value("${db.pass}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( "org.postgresql.Driver" );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan( "spring.model" );
        sessionFactory.setDataSource( dataSource() );
        sessionFactory.setHibernateProperties( hibernateProperties() );
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory( sessionFactory().getObject() );
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty( Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect" );
        properties.setProperty( Environment.SHOW_SQL, "true" );
        properties.setProperty( Environment.HBM2DDL_AUTO, "create" );
        return properties;
    }

    @Bean
    public ViewResolver getView() {
        return new InternalResourceViewResolver( "/WEB-INF/views/", ".jsp" );
    }
}