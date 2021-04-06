package synegros.walter.myadminpage.model.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import synegros.walter.myadminpage.web.dto.response.MemberResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void memberRead(){

        List<MemberResponseDto> memberResponseDtoList = memberRepository.findAll().stream().map(MemberResponseDto::new).collect(Collectors.toList());

        for(MemberResponseDto m : memberResponseDtoList){
            log.info("{}", m.getCreatedAt());
        }

    }
}