package testinglombok.jdbc;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConnections {
    @Bean
    public DriverManagerDataSource MyJdbcConnection(){
DriverManagerDataSource source=new DriverManagerDataSource();
source.setUsername("root");
source.setPassword("Arvin3der");
source.setUrl("jdbc:mysql://localhost:3306/jdbcspring");
source.setDriverClassName("com.mysql.cj.jdbc.Driver");
return source;
    }
    @Bean
    public JdbcTemplate mytempale(){
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(MyJdbcConnection());
        return template;
    }
}
