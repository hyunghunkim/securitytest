package org.secu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.secu.domain.MemberVO;
import org.secu.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@AllArgsConstructor
public class commonController {

    private MemberService service;

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model){
        model.addAttribute("msg","Access Denied");
    }

    @GetMapping("/customLogin")
    public void loginInput(String error,String logout,Model model){

        if (error != null){
            model.addAttribute("error","Login Error Check Your Account");
        }
        if (logout != null){
            model.addAttribute("logout","Logout!");
        }
    }

    @GetMapping("/customLogout")
    public void logoutGET(){

    }

    @GetMapping("/member")
    public String sign(){
        return "/member";
    }

    @PostMapping("/signup")
    public String signup(MemberVO memberVO){
        log.info(memberVO);
        service.insert(memberVO);
        return "/customLogin";
    }

    @RequestMapping(value = "/member/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck(@RequestParam("username") String username) {

        return service.userIdCheck(username);
    }

}
