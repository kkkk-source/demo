package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Item;
import com.example.demo.entity.Sale;
import com.example.demo.entity.SaleLineItem;
import com.example.demo.entity.Store;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.SaleLineItemRepository;
import com.example.demo.repository.StoreRepository;

@SpringBootApplication
public class DemoApplication
    implements CommandLineRunner
{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SaleLineItemRepository saleLineItemRepository;

    public static void main( String[] args )
    {
        SpringApplication.run( DemoApplication.class, args );
    }

    @Override
    public void run( String... args )
        throws Exception
    {
        Store store = Store.builder().name( "nvm" ).build();
        Store storeCreated = storeRepository.save( store );

        Item item1 = Item.builder().name( "pencil" ).price( new BigDecimal( 200 ) ).store( storeCreated ).build();
        Item item2 = Item.builder().name( "airpod" ).price( new BigDecimal( 400 ) ).store( storeCreated ).build();
        Item itemCreated1 = itemRepository.save( item1 );
        Item itemCreated2 = itemRepository.save( item2 );

        SaleLineItem saleLineItemToAdd1 = SaleLineItem.builder().item( item1 ).quantity( 2 ).build();
        SaleLineItem saleLineItemToAdd2 = SaleLineItem.builder().item( item2 ).quantity( 1 ).build();

        List<SaleLineItem> saleLineItems = new ArrayList<SaleLineItem>();
        saleLineItems.add( saleLineItemToAdd1 );
        saleLineItems.add( saleLineItemToAdd2 );

        Sale saleToCreate = Sale.builder().store( storeCreated ).date( LocalDateTime.now() ).build();
        Sale saleCreated = saleRepository.save( saleToCreate );

        saleLineItems.stream().forEach( ( saleLineItemToSave ) -> {
            saleLineItemToSave.setSale( saleCreated );
            saleLineItemRepository.save( saleLineItemToSave );
        } );
    }
}
