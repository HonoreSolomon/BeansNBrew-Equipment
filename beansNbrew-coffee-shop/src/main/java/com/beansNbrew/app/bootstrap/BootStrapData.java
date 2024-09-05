package com.beansNbrew.app.bootstrap;

import com.beansNbrew.app.domain.InhousePart;
import com.beansNbrew.app.domain.Product;
import com.beansNbrew.app.repositories.InhousePartRepository;
import com.beansNbrew.app.repositories.OutsourcedPartRepository;
import com.beansNbrew.app.repositories.PartRepository;
import com.beansNbrew.app.repositories.ProductRepository;
import com.beansNbrew.app.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository= inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long partCount = partRepository.count();
        long productCount = productRepository.count();

        if (partCount == 0 && productCount == 0) {

            InhousePart part1 = new InhousePart();
            part1.setName("Boiler");
            part1.setPrice(150.0);
            part1.setInv(30);
            part1.setPartId(101);
            part1.setMin(1);
            part1.setMax(30);

            inhousePartRepository.save(part1);

            InhousePart part2 = new InhousePart();
            part2.setName("Motor");
            part2.setPrice(100.0);
            part2.setInv(40);
            part2.setPartId(102);
            part2.setMin(1);
            part2.setMax(50);

            inhousePartRepository.save(part2);

            InhousePart part3 = new InhousePart();
            part3.setName("Filter");
            part3.setPrice(10.0);
            part3.setInv(100);
            part3.setPartId(103);
            part3.setMin(10);
            part3.setMax(200);

            inhousePartRepository.save(part3);

            InhousePart part4 = new InhousePart();
            part4.setName("Portafilter");
            part4.setPrice(25.0);
            part4.setInv(60);
            part4.setPartId(104);
            part4.setMin(1);
            part4.setMax(100);

            inhousePartRepository.save(part4);

            InhousePart part5 = new InhousePart();
            part5.setName("Steam Wand");
            part5.setPrice(45.0);
            part5.setInv(50);
            part5.setPartId(105);
            part5.setMin(1);
            part5.setMax(100);

            inhousePartRepository.save(part5);


            Product product1 = new Product("Espresso Machine", 850.0, 10 );
            Product product2 = new Product("Coffee Grinder", 250.0, 25);
            Product product3 = new Product("Pour Over Kit", 75.0, 50);
            Product product4 = new Product("Automatic Drip Coffee Maker", 350.0, 20);
            Product product5 = new Product("Cappuccino Maker", 400, 15);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
