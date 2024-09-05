package com.beansNbrew.app.controllers;

import com.beansNbrew.app.domain.InhousePart;
import com.beansNbrew.app.service.InhousePartService;
import com.beansNbrew.app.service.InhousePartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);

        if (part.getInv() < part.getMin()) {
            theBindingResult.rejectValue("inv", "Error InhousePart", "Inventory cannot be less than the minimum value of " + part.getMin());
        } else if (part.getInv() > part.getMax()) {
            theBindingResult.rejectValue("inv", "Error InhousePart", "Inventory cannot be greater than maximum value of " + part.getMax());
        }

        if (!part.isInvValid()) {
            theBindingResult.rejectValue("inv", "Error InhousePart", "Inventory must be between " + part.getMin() + " and " + part.getMax() + ".");
        }
        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }
        else{
        InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setProducts(ip.getProducts());
            repo.save(part);

        return "confirmationaddpart";}
    }

}
