package com.beansNbrew.app.controllers;

import com.beansNbrew.app.domain.OutsourcedPart;
import com.beansNbrew.app.domain.Part;
import com.beansNbrew.app.service.OutsourcedPartService;
import com.beansNbrew.app.service.OutsourcedPartServiceImpl;
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
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);

        if (part.getInv() < part.getMin()) {
            bindingResult.rejectValue("inv", "Error OutsourcedPart", "Inventory cannot be less than the minimum value of " + part.getMin());
        } else if (part.getInv() > part.getMax()) {
            bindingResult.rejectValue("inv", "Error OutsourcedPart", "Inventory cannot be greater than maximum value of " + part.getMax());
        }

        if (!part.isInvValid()) {
            bindingResult.rejectValue("inv", "Error OutsourcedPart", "Inventory must be between " + part.getMin() + " and " + part.getMax() + ".");
        }

        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else{
        OutsourcedPartService repo=context.getBean(OutsourcedPartServiceImpl.class);
        OutsourcedPart op=repo.findById((int)part.getId());
        if(op!=null)part.setProducts(op.getProducts());
            repo.save(part);
        return "confirmationaddpart";}
    }



}
