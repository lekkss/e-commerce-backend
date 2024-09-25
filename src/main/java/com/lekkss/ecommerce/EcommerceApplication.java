package com.lekkss.ecommerce;

import com.github.javafaker.Faker;
import com.lekkss.ecommerce.models.Product;
import com.lekkss.ecommerce.models.ProductCategory;
import com.lekkss.ecommerce.repositories.ProductCategoryRepository;
import com.lekkss.ecommerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			ProductCategoryRepository  productCategoryRepository,
//			ProductRepository productRepository
//	) {
//		return args -> {
//			for (int i = 0; i < 10; i++) {
//				Faker faker = new Faker();
//				var productCategory =  ProductCategory.builder().name(faker.color().name()).description("nothing").build();
////				productCategoryRepository.save(productCategory);
//			}
//
//			for (int i = 0; i < 10; i++) {
//				Faker faker = new Faker();
//				var product = Product.builder().price(10.0).SKU("").description("").category().build();
//			}
//		};
//	}

}
