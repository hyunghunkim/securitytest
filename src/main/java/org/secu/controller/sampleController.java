package org.secu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class sampleController {

    @GetMapping("/all")
    public void doAll(){

    }

    @GetMapping("/member")
    public void doMemvber(){
    }

    @GetMapping("/admin")
    public void doAdmin(){
    }

    @GetMapping("/client")
    public void doClient(){
    }

    @GetMapping("/partners")
    public void doPartners(){
    }
}
