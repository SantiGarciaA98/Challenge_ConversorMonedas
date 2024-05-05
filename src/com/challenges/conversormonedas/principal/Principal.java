package com.challenges.conversormonedas.principal;

import com.challenges.conversormonedas.Conversor;
import com.challenges.conversormonedas.HistorialConversiones;
import com.challenges.conversormonedas.LocalDate.LocalDateConfig;
import com.challenges.conversormonedas.Moneda;
import com.challenges.conversormonedas.MonedaString;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        List<MonedaString> conversiones =new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                //Decirle al Json como manejar localDate desde MonedaString class
                .registerTypeAdapter(LocalDate.class, new LocalDateConfig())
                .create();
        int eleccionUsuario = 0;

        try{
            while (eleccionUsuario != 7){
                HistorialConversiones listaConversiones = new HistorialConversiones();
                System.out.println("1. Dólar Americano ==> Peso Colombiano\n" +
                        "2. Peso Colombiano ==> Dólar Americano\n" +
                        "3. Dólar Americano ==> Peso Argentino\n" +
                        "4. Peso Argentino ==> Dólar Americano\n" +
                        "5. Dólar Americano ==> Peso Chileno\n" +
                        "6. Peso Chileno ==> Dólar Americano\n" +
                        "7.Salir");
                System.out.println("Escriba la conversión que desea realizar: ");
                eleccionUsuario = teclado.nextInt();

                if (eleccionUsuario !=7){
                    System.out.println("Escriba la cantidad que desea convertir: ");
                    Float cantidadUsuario = teclado.nextFloat();

                    Conversor conversor = new Conversor();
                    Moneda moneda = conversor.conversorMonedas(eleccionUsuario, cantidadUsuario);

                    MonedaString miMoneda = new MonedaString(moneda, cantidadUsuario, LocalDate.now());
                    System.out.println(miMoneda);
                    conversiones.add(miMoneda);
                    System.out.println("*******************************");
                    listaConversiones.imprimirHistorialConversiones(conversiones);
                    System.out.println("*******************************");
                } else {
                    break;
                }
            }

            FileWriter escritura = new FileWriter("conversiones.json");
            escritura.write(gson.toJson(conversiones));
            escritura.close();
            System.out.println("Finalizó el programa");


        } catch (NumberFormatException | IOException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Error en los argumentos ingresados");
        } catch (InputMismatchException e){
            System.out.println("Debe ingresar lo requerido en cada campo.");
        }
    }
}
