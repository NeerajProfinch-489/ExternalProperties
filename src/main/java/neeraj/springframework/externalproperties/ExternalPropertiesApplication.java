package neeraj.springframework.externalproperties;

import neeraj.springframework.externalproperties.model.FakeDataSource;
import neeraj.springframework.externalproperties.model.FakeJsmDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExternalPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ExternalPropertiesApplication.class, args);
		FakeDataSource fakeDataSource = (FakeDataSource)applicationContext.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());

		FakeJsmDataSource fakeJsmDataSource = (FakeJsmDataSource) applicationContext.getBean(FakeJsmDataSource.class);
		System.out.println(fakeJsmDataSource.getUserName());
	}

}
