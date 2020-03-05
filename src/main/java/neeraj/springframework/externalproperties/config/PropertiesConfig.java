package neeraj.springframework.externalproperties.config;

import neeraj.springframework.externalproperties.model.FakeDataSource;
import neeraj.springframework.externalproperties.model.FakeJsmDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jsm.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jsm.properties")
})
public class PropertiesConfig {

    @Autowired
    Environment ev;

    @Value("${neeraj.jsm.username}")
    private String jsmUserName;
    @Value("${neeraj.jsm.userpass}")
    private String jsmUserPassword;
    @Value("${neeraj.jsm.url}")
    private String jsmUrl;


    @Value("${neeraj.username}")
    private String userName;
    @Value("${neeraj.userpass}")
    private String userPassword;
    @Value("${neeraj.url}")
    private String url;

    @Bean
    public FakeDataSource doFakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(ev.getProperty("USERNAME"));
       // fakeDataSource.setUserName(userName);
        fakeDataSource.setUserPassword(userPassword);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJsmDataSource fakeJsmDataSource(){
        FakeJsmDataSource fakeJsmDataSource = new FakeJsmDataSource();
        fakeJsmDataSource.setUserName(jsmUserName);
        fakeJsmDataSource.setUserPassword(jsmUserPassword);
        fakeJsmDataSource.setUserUrl(jsmUrl);
        return fakeJsmDataSource;
    }

    @Bean
    public static PropertyPlaceholderAutoConfiguration properties(){
        PropertyPlaceholderAutoConfiguration propertyPlaceholderAutoConfiguration = new PropertyPlaceholderAutoConfiguration();
        return propertyPlaceholderAutoConfiguration;
    }

}
