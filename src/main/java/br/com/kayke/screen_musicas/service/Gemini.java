package br.com.kayke.screen_musicas.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;


public class Gemini {
    public void gerarDescrição(String nome){

        //Client client = Client.builder().apiKey(GEMINI_API_KEY).build();
        Client client = new Client();
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "De uma breve descrição do artista" + nome + "caso não encontra o artista apenas fale" +
                                "Artista não encontrado",
                        null);

        System.out.println(response.text());
    }
}
