package gr.com.service;

import com.google.gson.Gson;
import gr.com.modelos.Monedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
        public Monedas buscaMonedas(String busqueda){
            String API_KEY = "d980ac90faaf1388c0d57acb";
            String URL   = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + busqueda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(),Monedas.class);

            } catch (IOException|InterruptedException e) {
                throw new RuntimeException("Moneda no encontrada");
            }

        }
}
