package synegros.walter.myadminpage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

    /* ================ admin manage ========================== */

    String adminmanage = "/adminmanage";

    @GetMapping("/adminmanage")
    public String adminManage(){
        return adminmanage + "/adminmanage";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
