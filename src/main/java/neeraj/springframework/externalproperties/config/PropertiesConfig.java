package neeraj.springframework.externalproperties.config;

import neeraj.springframework.externalproperties.model.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertiesConfig {
    @Value("${neeraj.username}")
    private String userName;
    @Value("${neeraj.userpass}")
    private String userPassword;
    @Value("${neeraj.url}")
    private String url;

    @Bean
    public FakeDataSource doFakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setUserPassword(userPassword);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public static PropertyPlaceholderAutoConfiguration properties(){
        PropertyPlaceholderAutoConfiguration propertyPlaceholderAutoConfiguration = new PropertyPlaceholderAutoConfiguration();
        return propertyPlaceholderAutoConfiguration;
    }

}
