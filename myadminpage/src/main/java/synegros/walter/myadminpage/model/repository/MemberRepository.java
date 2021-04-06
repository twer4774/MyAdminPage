package synegros.walter.myadminpage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import synegros.walter.myadminpage.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
