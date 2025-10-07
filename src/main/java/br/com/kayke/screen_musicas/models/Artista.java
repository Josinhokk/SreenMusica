package br.com.kayke.screen_musicas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private String categoria;


    @OneToMany(mappedBy = "artista" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public Artista() {

    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Artista(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }
}
