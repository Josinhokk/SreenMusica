package br.com.kayke.screen_musicas.repositorios;

import br.com.kayke.screen_musicas.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface musicaRepositorio extends JpaRepository<Musica, Integer> {
}
