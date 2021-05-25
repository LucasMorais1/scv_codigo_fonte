package com.scv.usuarioservice.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID = -7881666690610187105L;

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String marca;

    @NotBlank
    @Size(max = 200)
    private String modelo;

    @NotNull
    private String anoModelo;

    @Size(max = 30)
    private String combustivel;

    @Size(max = 10)
    private String codigoFipe;

    private String valor;

    private String diaRodizio;

    private Boolean rodizioAtivo;

    @NotNull
    private Long usuarioId;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public Boolean getRodizioAtivo() {
        if (this.diaRodizio != null)
            this.definirRodizioAtivo(LocalDate.now());
        return rodizioAtivo;
    }

    private void definirRodizioAtivo(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        this.setRodizioAtivo(false);
        switch(dayOfWeek) {
            case FRIDAY:
                if (this.getDiaRodizio().equals("sexta-feira"))
                    this.setRodizioAtivo(true);
                break;
            case THURSDAY:
                if (this.getDiaRodizio().equals("quinta-feira"))
                    this.setRodizioAtivo(true);
                break;
            case WEDNESDAY:
                if (this.getDiaRodizio().equals("quarta-feira"))
                    this.setRodizioAtivo(true);
                break;
            case TUESDAY:
                if (this.getDiaRodizio().equals("terça-feira"))
                    this.setRodizioAtivo(true);
                break;
            case MONDAY:
                if (this.getDiaRodizio().equals("segunda-feira"))
                    this.setRodizioAtivo(true);
                break;
        }
    }

    public void setRodizioAtivo(Boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }
}
