package br.com.kayke.screen_musicas.repositorios;

import br.com.kayke.screen_musicas.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface musicaRepositorio extends JpaRepository<Musica, Integer> {

    @Query("SELECT m FROM Musica m WHERE m.artista.nome = :artista")
    List<Musica> musicaPorNomeArtista(String artista);
}
