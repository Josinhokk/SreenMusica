package br.com.kayke.screen_musicas.principal;

import br.com.kayke.screen_musicas.models.Artista;
import br.com.kayke.screen_musicas.models.Categoria;
import br.com.kayke.screen_musicas.models.Musica;
import br.com.kayke.screen_musicas.repositorios.artistaRepositorio;
import br.com.kayke.screen_musicas.repositorios.musicaRepositorio;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class Principal {

    @Autowired
    artistaRepositorio artistaRepositorio;

    @Autowired
    musicaRepositorio musicaRepositorio;

    Artista auxArtista;

    Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
//                case 4:
//                    buscarMusicasPorArtista();
//                    break;
//                case 5:
//                    pesquisarDadosDoArtista();
//                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }



    private void cadastrarArtistas() {
        System.out.println("Digite o nome do artista: ");
        var artista = leitura.nextLine();
        if (verificarBanco(artista)) {
            System.out.println("Qual a categoria do artista: (Solo, Dupla, Banda)");
            var categoriaProcurada = leitura.nextLine();
            String categoria = String.valueOf(Categoria.procurarCategoria(categoriaProcurada));
            Artista artistaProcurada = new Artista(artista, categoria);
            artistaRepositorio.save(artistaProcurada);
            auxArtista = artistaProcurada;
        }
        else {
            System.out.println("Artista ja cadastrado!");
        }
    }

    //Trocar por optional para evitar erros
    private void cadastrarMusicas() {
        System.out.println("Digite o nome da musica");
        var musica = leitura.nextLine();
        System.out.println("Qual o genero da musica:  ");
        var genero = leitura.nextLine();
        System.out.println("Qual Artista compositor dessa musica: ");
        String artistaCompositor = leitura.nextLine();
        Optional<Artista> artistaProcurado = artistaRepositorio.getArtistaByNomeEqualsIgnoreCase((artistaCompositor));
        if (artistaProcurado.isPresent()) {
            Artista artista = artistaProcurado.get();
            Musica musicaProcurada = new Musica(musica, genero,artista);
            musicaRepositorio.save(musicaProcurada);
            System.out.println("MUSICA CADASTRADA COM SUCESSO!");
        }else {
            System.out.println("ARTISTA NÃO CADASTRADO!!!");
            System.out.println("""
                    Deseja cadastra um artista?
                    
                    1 - Cadastrar artista
                    2 - Sair
                    
                    
                    """);
            var opc = leitura.nextInt();
            leitura.nextLine();
            if(opc == 1){
                cadastrarArtistas();
                System.out.println("ARTISTA CADASTRADO COM SUCESSO!!!");
//                System.out.println("Vamos prosseguir");
//                Artista artistaMusical = artistaRepositorio.findByNomeContainingIgnoreCase(auxArtista.getNome());
//                Musica musicaProcurada = new Musica(musica, genero, artistaMusical);
//                musicaRepositorio.save(musicaProcurada);
//                System.out.println("MUSICA CADASTRADA COM SUCESSO!!!");
            }else{
                System.out.println("Saindo...");
            }
        }
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepositorio.findAll();
        musicas.forEach(m -> System.out.println(
                "Musica: " + m.getNome()
                + "\nGenero: " + m.getGenero()
                + "\nArtista: " + m.getArtista().getNome()
        ));

    }

    public boolean verificarBanco(String artista){
        artistaRepositorio.existsArtistaByNomeContainingIgnoreCase(artista);
        return true;
    }
}
