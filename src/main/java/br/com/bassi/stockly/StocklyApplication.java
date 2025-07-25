package br.com.bassi.stockly;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StocklyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocklyApplication.class, args);
	}


}
