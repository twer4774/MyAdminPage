package synegros.walter.myadminpage.model.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import synegros.walter.myadminpage.model.entity.AdminUser;
import synegros.walter.myadminpage.model.enums.Role;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class AdminUserRepositoryTest {

    @Autowired
    private AdminUserRepository adminUserRepository;

//    @Disabled
    @Test
//    @Transactional
    public void createAdmin(){
        //myadmin1234를 기본 비밀번호로 한다.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String defaultPw = passwordEncoder.encode("super1234");

//        AdminUser adminUser = AdminUser.builder()
//                .adminId("myadmin")
//                .password(defaultPw)//비밀번호를 암호화 시켜서 저장한다.
//                .adminName("ADMIN")
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .build();

        AdminUser adminUser = AdminUser.builder()
                .adminId("superadmin")
                .password(defaultPw)//비밀번호를 암호화 시켜서 저장한다.
                .adminName("SUPER")
                .role(Role.SUPERADMIN.getValue())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        log.info("{}", adminUser);
        adminUserRepository.save(adminUser);
    }


    @Test
    @Transactional
    public void readAdmin(){
        Optional<AdminUser> myadmin = adminUserRepository.findByAdminId("myadmin");

        assertNotNull(myadmin);
        assertEquals(myadmin.get().getAdminName(), "ADMIN");


    }

    //AdminName 변경 테스트
    /* todo
    * 암호의 변경인 경우 LoginService를 이용하여 암호화 시켜서 업데이트가 이루어져야한다.
    * 현재 설정된 암호는 기본적으로 제공되는 암호로 데이터베이스에서 암호화가 되어있지 않다.
    * */
    @Test
    @Transactional
    public void updateAdmin(){
        Optional<AdminUser> myadmin = adminUserRepository.findByAdminId("myadmin");

        myadmin.ifPresent(selectAdminUser -> {
                selectAdminUser.setAdminName("ADMINUSER1");
                selectAdminUser.setUpdatedAt(LocalDateTime.now());

            adminUserRepository.save(selectAdminUser);
        });

        Optional<AdminUser> newMyadmin = adminUserRepository.findByAdminId("myadmin");
        assertEquals(newMyadmin.get().getAdminName(), "ADMINUSER");

    }

}