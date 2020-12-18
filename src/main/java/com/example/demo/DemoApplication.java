package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.SaleSaveResponse;
import com.example.demo.controller.SoldListResponse;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Sold;
import com.example.demo.entity.Product;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.SoldRepository;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
public class DemoApplication
    implements CommandLineRunner
{

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SoldRepository soldRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main( String[] args )
    {
        SpringApplication.run( DemoApplication.class, args );
    }

    @Override
    public void run( String... args )
        throws Exception
    {
        Product product1 = Product.builder().price( new BigDecimal( 200 ) ).name( "pencil" ).build();
        Product product2 = Product.builder().price( new BigDecimal( 4000 ) ).name( "peace" ).build();

        Product productCreated1 = productRepository.save( product1 );
        Product productCreated2 = productRepository.save( product2 );

        Sale sale1 = Sale.builder().price( new BigDecimal( 4200 ) ).build();
        Sale saleCreated1 = saleRepository.save( sale1 );

        Sold sold1 = Sold.builder().sale( saleCreated1 ).product( productCreated1 ).amount( 1 ).build();
        Sold sold2 = Sold.builder().sale( saleCreated1 ).product( productCreated2 ).amount( 1 ).build();

        Sold soldCreated1 = soldRepository.save( sold1 );
        Sold soldCreated2 = soldRepository.save( sold2 );

        Optional<Sale> saleInDatabase = saleRepository.findById( saleCreated1.getId() );
        saleInDatabase.get().getSold().stream().forEach( ( sold ) -> {
            System.out.printf( "id: %d, price: %.2f, amount: %d, " + "id: %d, name: %s, price: %.2f\n",
                               saleInDatabase.get().getId(), saleInDatabase.get().getPrice(), sold.getAmount(),
                               sold.getProduct().getId(), sold.getProduct().getName(), sold.getProduct().getPrice() );
        } );

        List<Sold> soldList = soldRepository.findBySaleId( new Long( 1 ) );
        soldList.stream().forEach( ( sold ) -> {
            System.out.printf( "sale: %d price: %.2f\namount: %d\nproduct: %d name: %s price: %.2f\n",
                               sold.getSale().getId(), sold.getSale().getPrice(), sold.getAmount(),
                               sold.getProduct().getId(), sold.getProduct().getName(), sold.getProduct().getPrice() );
        } );

        List<SoldListResponse> soldToResponse =
            soldList.stream().map( SoldListResponse::fromModel ).collect( Collectors.toList() );
        soldToResponse.stream().forEach( ( product ) -> {
            System.out.printf( "id: %d, name: %s, price: %.2f, amount: %d\n", product.getId(), product.getName(),
                               product.getPrice(), product.getAmount() );
        } );

        SaleSaveResponse saleToResponse = SaleSaveResponse.fromModel( saleInDatabase.get() );
        System.out.printf( "\nid : %d\n", saleToResponse.getId() );
        System.out.printf( "price : %.2f\n", saleToResponse.getPrice() );
        saleToResponse.getProducts().stream().forEach( ( product ) -> {
            System.out.printf( "id: %d, name: %s, price: %.2f, amount: %d\n", product.getId(), product.getName(),
                               product.getPrice(), product.getAmount() );
        } );
    }
}
