package synegros.walter.myadminpage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import synegros.walter.myadminpage.model.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
