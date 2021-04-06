package synegros.walter.myadminpage.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import synegros.walter.myadminpage.model.entity.Member;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String memberId;
    private String password;
    private String nickName;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
        this.nickName = member.getNickName();
        this.gender = member.getGender();
        this.createdAt = member.getCreatedAt();
        this.updatedAt = member.getUpdatedAt();
    }
}
