package com.business;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;


@SpringBootApplication
public class BusinessProjectApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BusinessProjectApplication.class, args);
	
	}

	@Bean
	public CommandLineRunner initializeProducts(ProductRepository productRepository) {
		return args -> {
			// Check if products already exist
			if (productRepository.count() == 0) {
				// Add 5 sample products
				Product p1 = new Product();
				p1.setPname("Business Laptop Pro");
				p1.setPprice(1299.99);
				p1.setPdescription("High-performance laptop with Intel i7, 16GB RAM, 512GB SSD - Perfect for business professionals and developers");
				productRepository.save(p1);
				
				Product p2 = new Product();
				p2.setPname("Office Chair Executive");
				p2.setPprice(499.99);
				p2.setPdescription("Premium ergonomic office chair with lumbar support, adjustable height, and 5-year warranty");
				productRepository.save(p2);
				
				Product p3 = new Product();
				p3.setPname("LED Desk Lamp");
				p3.setPprice(79.99);
				p3.setPdescription("Modern LED desk lamp with adjustable brightness, touch control, USB charging port, and energy-efficient design");
				productRepository.save(p3);
				
				Product p4 = new Product();
				p4.setPname("Business Notebook Set");
				p4.setPprice(49.99);
				p4.setPdescription("Professional quality notebook set with premium paper, hard cover, and gold-lettered spine - Pack of 3");
				productRepository.save(p4);
				
				Product p5 = new Product();
				p5.setPname("Wireless Bluetooth Headphones");
				p5.setPprice(199.99);
				p5.setPdescription("Premium noise-cancelling Bluetooth headphones with 30-hour battery life, perfect for calls and music");
				productRepository.save(p5);
				
				System.out.println("✅ 5 sample products initialized successfully!");
			}
		};
	}

}
