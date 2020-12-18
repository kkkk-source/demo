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
import com.example.demo.controller.SaleSaveRequest;
import com.example.demo.controller.SoldListResponse;
import com.example.demo.controller.SoldListRequest;
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

        SoldListRequest productToAdd1 =
            SoldListRequest.builder().id( productCreated1.getId() ).name( productCreated1.getName() ).price( productCreated1.getPrice() ).amount( 1 ).build();
        SoldListRequest productToAdd2 =
            SoldListRequest.builder().id( productCreated2.getId() ).name( productCreated2.getName() ).price( productCreated2.getPrice() ).amount( 1 ).build();

        List<SoldListRequest> products = new ArrayList<SoldListRequest>();
        products.add( productToAdd1 );
        products.add( productToAdd2 );

        SaleSaveRequest saleRequestToSave =
            SaleSaveRequest.builder().price( new BigDecimal( 4200 ) ).products( products ).build();
        Sale saleToSave = SaleSaveRequest.toModel( saleRequestToSave );
        Sale saleCreated = saleRepository.save( saleToSave );

        products.stream().forEach( ( product ) -> {
            Sold soldToSave = SoldListRequest.toModel( product );
            soldToSave.setSale( saleCreated );
            soldRepository.save( soldToSave );
        } );

        Long id = new Long( 3 );
        Optional<Sale> saleInDatabaseOptional = saleRepository.findById( id );
        if ( saleInDatabaseOptional.isEmpty() )
        {
            System.err.printf( "demo: there is not a sale with id = %d", id );
            return;
        }

        Sale saleInDatabase = saleInDatabaseOptional.get();
        SaleSaveResponse saleToResponse = SaleSaveResponse.fromModel( saleInDatabase );
        System.out.printf( "{ id: %d, price: %.2f, products: [\n", saleToResponse.getId(), saleToResponse.getPrice() );
        saleToResponse.getProducts().stream().forEach( ( product ) -> {
            System.out.printf( "\t{ id: %d, name: %s, price: %.2f, amount: %d }\n", product.getId(), product.getName(),
                               product.getPrice(), product.getAmount() );
        } );
        System.out.println( "]}" );

    }
}
