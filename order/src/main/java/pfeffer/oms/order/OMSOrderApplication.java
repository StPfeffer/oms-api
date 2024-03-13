package pfeffer.oms.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pfeffer.oms.inventory", "pfeffer.oms.logistic"})
public class OMSOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OMSOrderApplication.class, args);
	}

}
