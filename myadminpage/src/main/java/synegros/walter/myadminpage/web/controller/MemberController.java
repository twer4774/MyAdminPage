package synegros.walter.myadminpage.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import synegros.walter.myadminpage.service.MemberService;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberList")
    public String memberList(
            @PathParam("page") String page,
            Model model,
            @PageableDefault(size= 10) Pageable pageable){
        String membermanage = "/membermanage";


        model.addAttribute("memberList", memberService.getAllMemberList(pageable));
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("Previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("Next", pageable.next().getPageNumber());


        return membermanage + "/memberList";
    }
}
