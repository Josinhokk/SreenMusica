package br.com.kayke.screen_musicas.repositorios;

import br.com.kayke.screen_musicas.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface artistaRepositorio extends JpaRepository<Artista, Integer> {
    boolean findByNomeEquals(String artista);

    Artista getArtistaByNomeEqualsIgnoreCase(String artista);
}
