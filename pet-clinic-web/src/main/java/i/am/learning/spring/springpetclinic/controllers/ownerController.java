package i.am.learning.spring.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ownerController {

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String listOwner(){
        return "owners/index";
    }
}
