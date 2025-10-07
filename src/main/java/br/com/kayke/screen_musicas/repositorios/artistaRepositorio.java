package br.com.kayke.screen_musicas.repositorios;

import br.com.kayke.screen_musicas.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface artistaRepositorio extends JpaRepository<Artista, Integer> {
    Optional<Artista> getArtistaByNomeEqualsIgnoreCase(String artista);

    boolean findByNomeContainingIgnoreCase(String artista);

    boolean existsArtistaByNomeContainingIgnoreCase(String artista);
}
