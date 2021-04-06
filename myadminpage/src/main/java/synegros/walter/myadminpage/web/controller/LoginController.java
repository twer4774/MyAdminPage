package synegros.walter.myadminpage.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import synegros.walter.myadminpage.model.entity.AdminUser;
import synegros.walter.myadminpage.service.LoginService;

import java.util.Optional;

@Slf4j
@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping({"/", ""})
    public String loginForm(){
        return "loginForm";
    }

    /*@PostMapping("/loginCheck")
    //todo : 된다면 adminUerDto 만들기
    public Optional<AdminUser> loginCheck(AdminUser adminUser){
        String adminId = adminUser.getAdminId();
        String password = adminUser.getPassword();


        return loginService.login(adminId, password);
    }*/

}
