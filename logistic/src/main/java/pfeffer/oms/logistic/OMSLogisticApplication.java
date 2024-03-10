package pfeffer.oms.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pfeffer.oms.inventory"})
public class OMSLogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(OMSLogisticApplication.class, args);
    }

}
