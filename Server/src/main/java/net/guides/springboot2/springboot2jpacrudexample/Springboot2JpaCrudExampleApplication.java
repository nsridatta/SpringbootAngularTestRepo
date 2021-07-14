package net.guides.springboot2.springboot2jpacrudexample;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.actuate.env.EnvironmentEndpoint;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class Springboot2JpaCrudExampleApplication {

	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee employee;
	public static void main(String[] args) {
		SpringApplication.run(Springboot2JpaCrudExampleApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			employeeRepository.save(new Employee("John","Papa","John.papa@gmail.com"));
			employeeRepository.save(new Employee("Rambo","Lars","rambo.lars@gmail.com"));
			employeeRepository.save(new Employee("bamboo","tree","bamboo.tree@gmail.com"));
		};
	}
	/*
	To Find the list of beans present in the running spring boot application
	*

	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.out::println);

		};
	}
	*/
	@Autowired
	private EnvironmentEndpoint envEndPnt;
	/*
	* This method masks actuator environment password and secret keys*/
	@PostConstruct
	public void initApplication() {
		envEndPnt.setKeysToSanitize("password","secret");
	}
}
