package com.example.davelist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by student on 6/21/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute(new Property());
        Property p1 = new Property();
        Property p2 = new Property();
        Property p3 = new Property();
        p1.setAddress("abc");
        p2.setAddress("def");
        p3.setAddress("ghi");
        ArrayList<Property> pL = new ArrayList<Property>();
        pL.add(p1);
        pL.add(p2);
        pL.add(p3);
        model.addAttribute("propList", pL);
        model.addAttribute(new Property());
        return "Propertylist";
    }

    @RequestMapping("/add")
    public String add(@Valid Property property, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Input";
        }

        return "Propertylist";
    }


    @RequestMapping(value="/moreinfo/{address}")
    public @ResponseBody String moreInfo(@PathVariable(value="address") String address, Model model) {
        return address;
    }


}
