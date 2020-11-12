package org.secu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
