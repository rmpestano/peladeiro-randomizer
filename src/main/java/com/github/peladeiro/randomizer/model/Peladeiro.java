/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.peladeiro.randomizer.model;

/**
 * @author rmpestano
 */
public class Peladeiro {

    private String nome;

    private Double pontuacaoMedia;// nro vitorias/nro jogos

    private Double artilhariaMedia;


    public String getNome() {
        return nome;
    }

    public Peladeiro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getArtilhariaMedia() {
        return artilhariaMedia;
    }

    public Peladeiro setArtilhariaMedia(Double artilhariaMedia) {
        this.artilhariaMedia = artilhariaMedia;
        return this;
    }

    /**
     * nro de pontos/nro de peladas
     */
    public Double getPontuacaoMedia() {
        return pontuacaoMedia;
    }

    public Peladeiro setPontuacaoMedia(Double pontuacaoAbsoluta) {
        this.pontuacaoMedia = pontuacaoAbsoluta;
        return this;
    }

    /**
     * Score do peladeiro = (pontuacao media * 15%) * artilharia media
     * 
     * nro de vitorias deve ter peso maior que a artilharia
     * @return
     */
    public Double getScore() {
        return (pontuacaoMedia * 1.15) * artilhariaMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peladeiro peladeiro = (Peladeiro) o;

        return !(nome != null ? !nome.equals(peladeiro.nome) : peladeiro.nome != null);

    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
