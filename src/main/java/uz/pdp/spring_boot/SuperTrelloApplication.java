package uz.pdp.spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.reposiroty.auth.AuthUserRepository;

import java.util.Arrays;

@SpringBootApplication
public class SuperTrelloApplication /*implements CommandLineRunner*/ {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SuperTrelloApplication(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(SuperTrelloApplication.class, args);
    }

    public void run(String... args) throws Exception {


        AuthUser admin1 = new AuthUser();
        admin1.setUsername("admin");
        admin1.setPassword(passwordEncoder.encode("123"));
        admin1.setActive(true);
        admin1.setBlocked(false);
        admin1.setLanguage("EN");


//        AuthUser user2 = new AuthUser();
//
//        user2.setUsername("user2");
//        user2.setPassword(passwordEncoder.encode("user2"));
//        user2.setActive(false);
//        user2.setBlocked(false);

        authUserRepository.saveAll(Arrays.asList(admin1));

    }
}
