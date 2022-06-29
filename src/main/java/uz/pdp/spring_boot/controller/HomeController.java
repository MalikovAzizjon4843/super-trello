package uz.pdp.spring_boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.entity.auth.AuthUser;

@Controller
public class HomeController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
       AuthUser user =((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        if (user.getRole().getCode().equals("SUPER_ADMIN")) return "panel/superAdmin";
        if (user.getRole().getCode().equals("ADMIN")) return "panel/admin";
        if (user.getRole().getCode().equals("MANAGER")) return "panel/manager";
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping("/secure")
    private String securedPage() {
        return "<h1>Secured Page </h1>";
    }
}
