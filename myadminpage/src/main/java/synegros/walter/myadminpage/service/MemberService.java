package synegros.walter.myadminpage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import synegros.walter.myadminpage.model.repository.MemberRepository;
import synegros.walter.myadminpage.web.dto.response.MemberResponseDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public List<MemberResponseDto> getAllMemberList(){
        return memberRepository.findAll().stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }
}
