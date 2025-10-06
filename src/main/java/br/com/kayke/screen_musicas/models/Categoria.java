package br.com.kayke.screen_musicas.models;

public enum Categoria {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String categoria;


    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public static Categoria procurarCategoria(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }


}


