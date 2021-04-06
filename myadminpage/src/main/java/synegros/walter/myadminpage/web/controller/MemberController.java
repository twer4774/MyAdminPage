package synegros.walter.myadminpage.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import synegros.walter.myadminpage.service.MemberService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberlist")
    public String memberList(Model model){
        String membermanage = "/adminpage/membermanage";


        model.addAttribute("memberList", memberService.getAllMemberList());

        return membermanage + "/memberlist";
    }
}
