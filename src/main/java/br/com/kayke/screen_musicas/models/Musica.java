package br.com.kayke.screen_musicas.models;

import jakarta.persistence.*;

@Entity
public class Musica {

    @Id
    private long id;

    @Column
    private String nome;

    @Column(nullable = false)
    private String genero;

//    @Column(nullable = false)
//    private String duracao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

//    public void setDuracao(String duracao) {
//        this.duracao = duracao;
//    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    public Musica(String nome, String genero, Artista artista) {
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
    }

    @ManyToOne
    private Artista artista;
}
