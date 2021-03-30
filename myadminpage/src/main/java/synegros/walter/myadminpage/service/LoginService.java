package synegros.walter.myadminpage.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import synegros.walter.myadminpage.model.entity.AdminUser;
import synegros.walter.myadminpage.model.enums.Role;
import synegros.walter.myadminpage.model.repository.AdminUserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LoginService implements UserDetailsService {


    private AdminUserRepository adminUserRepository;

    public LoginService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    @Transactional
    public Optional<AdminUser> login(String adminId, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<AdminUser> adminUser = adminUserRepository.findByAdminId(adminId);

        if(adminUser.isPresent()){
            AdminUser loginUser = adminUser.get();

            AdminUser admin = AdminUser.builder()
                    .id(loginUser.getId())
                    .adminId(loginUser.getAdminId())
                    .password(loginUser.getPassword())
                    .adminName(loginUser.getAdminName())
                    .role(loginUser.getRole())
                    .role(loginUser.getRole())
                    .build();

            return Optional.of(admin);
        }

        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {

        //adminUser 정보 조회
        Optional<AdminUser> adminUser = adminUserRepository.findByAdminId(adminId);

        if(adminUser.isPresent()) {
            AdminUser admin = adminUser.get();

            AdminUser authAdmin = AdminUser.builder()
                    .id(admin.getId())
                    .adminId(admin.getAdminId())
                    .password(admin.getPassword())
                    .role(admin.getRole())
                    .adminName(admin.getAdminName())
                    .createdAt(admin.getCreatedAt())
                    .updatedAt(admin.getUpdatedAt())
                    .build();

            log.info("authAdmin : {}", authAdmin);
            return authAdmin;
        }
        return null;
    }
}
