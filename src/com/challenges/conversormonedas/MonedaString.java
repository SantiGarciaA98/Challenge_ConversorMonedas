package com.challenges.conversormonedas;

import java.time.LocalDate;

public class MonedaString {
    private String base;
    private String target;
    private Float tasa;
    private Float conversionTotal;
    private Float cantidadUsuario;
    private LocalDate fecha;

    public MonedaString(Moneda moneda, Float cantidadUsuario, LocalDate fecha) {
        this.base = moneda.base_code();
        this.target = moneda.target_code();
        this.tasa = moneda.conversion_rate();
        this.cantidadUsuario = cantidadUsuario;
        this.conversionTotal = moneda.conversion_result();
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "La cantidad de "+ cantidadUsuario +
                " " + base + " equivale a: " +
                conversionTotal + " " + target;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
