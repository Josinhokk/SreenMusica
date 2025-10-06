package br.com.kayke.screen_musicas;

import br.com.kayke.screen_musicas.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicasApplication implements CommandLineRunner {

    @Autowired
    Principal principal = new Principal();

    public static void main(String[] args) {
        SpringApplication.run(ScreenMusicasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        principal.exibeMenu();
    }
}
