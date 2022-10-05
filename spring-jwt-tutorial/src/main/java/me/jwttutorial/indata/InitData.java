package me.jwttutorial.indata;

import lombok.RequiredArgsConstructor;
import me.jwttutorial.entity.Authority;
import me.jwttutorial.entity.AuthorityRepository;
import me.jwttutorial.entity.User;
import me.jwttutorial.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        initMemberData();
    }

    private void initMemberData() {
        Authority authority1 = Authority.builder()
                .authorityName("ROLE_USER")
                .build();


        Authority authority2 = Authority.builder()
                .authorityName("ROLE_ADMIN")
                .build();
        authorityRepository.save(authority1);
        authorityRepository.save(authority2);
        userRepository.saveAll(
                List.of(
                        User.builder()
                                .username("admin")
                                .password(encoder.encode("admin"))
                                .nickname("admin")
                                .authorities(Collections.singleton(authority2))
                                .activated(true)
                                .build(),
                        User.builder()
                                .username("users")
                                .password(encoder.encode("users"))
                                .nickname("users")
                                .authorities(Collections.singleton(authority1))
                                .activated(true)
                                .build()
                )
        );
    }
}
