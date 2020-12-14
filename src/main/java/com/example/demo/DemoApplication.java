package com.example.demo;

import com.example.demo.entity.Sale;
import com.example.demo.entity.Product;
import com.example.demo.entity.SaleProduct;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SaleProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleProductRepository saleProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        saleProductRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
        saleRepository.deleteAllInBatch();

        Product product1 = Product.builder()
            .price(new BigDecimal(200))
            .name("pencil")
            .build();

        Product product2 = Product.builder()
            .price(new BigDecimal(4000))
            .name("peace")
            .build();

        Product productCreated1 = productRepository.save(product1);
        Product productCreated2 = productRepository.save(product2);
        // important
        //
        //
        // public class SaleService {} 
        Sale sale1 = Sale.builder()
            .price(new BigDecimal(4200))
            .build();

        Sale saleCreated1 = saleRepository.save(sale1);
        //
        //
        //
        //
        SaleProduct saleProduct1 = SaleProduct.builder()
            .saleId(saleCreated1.getId()).productId(productCreated1.getId())
            .sale(saleCreated1).product(productCreated1)
            .amount(1)
            .build();

        SaleProduct saleProduct2 = SaleProduct.builder()
            .saleId(saleCreated1.getId()).productId(productCreated2.getId())
            .sale(saleCreated1).product(productCreated2)
            .amount(1)
            .build();

        SaleProduct saleProductCreated2 = saleProductRepository.save(saleProduct1);
        SaleProduct saleProductCreated1 = saleProductRepository.save(saleProduct2);

        Optional<Sale> saleInDatabase = saleRepository.findById(saleCreated1.getId());
        for (SaleProduct product : saleInDatabase.get().getAmounts()) {
            System.out.println("price: " + product.getProduct().getPrice()
                    + " amount: " + product.getAmount());
        }
        // How to solve "could not initialize proxy - no Session" without make use of 
        // spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true in application.properties
    }
}
