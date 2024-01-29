package pfeffer.oms.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pfeffer.oms")
public class OMSInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OMSInventoryApplication.class, args);
    }

}