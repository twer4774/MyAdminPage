package synegros.walter.myadminpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {


    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/adminpage/admin";
    }

    /* ================ admin manage ========================== */

    String adminmanage = "/adminpage/adminmanage";

    @GetMapping("/adminmanage")
    public String adminManage(){
        return adminmanage + "/adminmanage";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
