package com.challenges.conversormonedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

    public Moneda conversorMonedas(int eleccionUsuario, Float cantidadUsuario){
        String direccion = "";
        List<MonedaString> conversiones = new ArrayList<> ();

        try {
            if (eleccionUsuario == 1){
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/USD/COP/"+ cantidadUsuario;
            } else if (eleccionUsuario == 2) {
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/COP/USD/" + cantidadUsuario;
            } else if (eleccionUsuario == 3) {
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/USD/ARS/" + cantidadUsuario;
            }else if (eleccionUsuario == 4) {
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/ARS/USD/" + cantidadUsuario;
            } else if (eleccionUsuario == 5) {
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/USD/CLP/" + cantidadUsuario;
            } else if (eleccionUsuario == 6) {
                direccion = "https://v6.exchangerate-api.com/v6" +
                        "/058253d02c266e81f82aaab7/pair/CLP/USD/" + cantidadUsuario;
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    //Agregar la URL para accederla.
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontré esa opción de conversión");
        }
    }


}
