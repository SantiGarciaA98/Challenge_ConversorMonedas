package com.challenges.conversormonedas;

import java.util.List;

public class HistorialConversiones {
    public void imprimirHistorialConversiones(List<MonedaString> conversiones) {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato de fecha según tus necesidades

        if (conversiones.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
            return;
        }

        System.out.println("Historial de conversiones:");
        for (MonedaString monedaString : conversiones) {
            System.out.println(monedaString.getFecha() + " - " + monedaString);

        }
    }
}
