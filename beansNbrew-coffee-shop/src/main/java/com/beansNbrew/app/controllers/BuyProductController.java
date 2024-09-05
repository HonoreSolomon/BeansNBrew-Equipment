package com.beansNbrew.app.controllers;



import com.beansNbrew.app.domain.Product;
import com.beansNbrew.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyProductController {

    private final ProductRepository productRepository;

    @Autowired
    public BuyProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);

                model.addAttribute("message", "Purchase Successful");
                return "redirect:/purchaseSuccess";
            }else {
                model.addAttribute("message", "Purchase Failed: Not enough inventory");
                return "redirect:/purchaseError";
            }
        }else {
            model.addAttribute("message", "Purchase Failed: Product Not Found");
            return "redirect:/purchaseError";
        }
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
    }


}
