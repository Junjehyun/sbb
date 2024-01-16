package com.mysite.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // user 레파지토리를 사용하여 회원(User) 데이터를 생성하는 create 메서드를 추가했다.
    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        // 스프링 시큐리티의 BCryptPasswordEncoder사용.. 암호화하여 비번을 저장한다..!
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

}
