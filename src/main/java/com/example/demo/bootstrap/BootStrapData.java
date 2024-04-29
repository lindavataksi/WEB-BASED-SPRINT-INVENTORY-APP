package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0) {
            OutsourcedPart clasp = new OutsourcedPart();
            clasp.setCompanyName("Pandora");
            clasp.setName("Clasp");
            clasp.setInv(250);
            clasp.setPrice(10.0);
            clasp.setId(100L);
            outsourcedPartRepository.save(clasp);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
    //        for(OutsourcedPart part:outsourcedParts){
    //            if(part.getName().equals("out test"))thePart=part;
    //        }
    //
    //        System.out.println(thePart.getCompanyName());
    
            OutsourcedPart chain = new OutsourcedPart();
            chain.setCompanyName("Pandora");
            chain.setName("Chain");
            chain.setInv(25);
            chain.setPrice(300.0);
            chain.setId(200L);
            outsourcedPartRepository.save(chain);
    
            OutsourcedPart pendant = new OutsourcedPart();
            pendant.setCompanyName("Pandora");
            pendant.setName("Pendant");
            pendant.setInv(50);
            pendant.setPrice(45.0);
            pendant.setId(300L);
            outsourcedPartRepository.save(pendant);
    
            OutsourcedPart gemstone = new OutsourcedPart();
            gemstone.setCompanyName("Pandora");
            gemstone.setName("Gemstone");
            gemstone.setInv(50);
            gemstone.setPrice(45.0);
            gemstone.setId(400L);
            outsourcedPartRepository.save(gemstone);
    
            OutsourcedPart diamond = new OutsourcedPart();
            diamond.setCompanyName("Pandora");
            diamond.setName("Diamond");
            diamond.setInv(10);
            diamond.setPrice(1000.0);
            diamond.setId(500L);
            outsourcedPartRepository.save(diamond);
        }
    
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        Product ring = new Product("Ring", 500.0, 35);
        Product necklace = new Product("Necklace", 1000.0, 90);
        Product bracelet = new Product("Bracelet", 175.0, 200);
        Product anklet= new Product("Anklet", 220.0, 4);
        Product earring = new Product("Earring", 150.0, 6);
        if (productRepository.count() == 0) {
            productRepository.save(ring);
            productRepository.save(necklace);
            productRepository.save(bracelet);
            productRepository.save(anklet);
            productRepository.save(earring);
        }



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
