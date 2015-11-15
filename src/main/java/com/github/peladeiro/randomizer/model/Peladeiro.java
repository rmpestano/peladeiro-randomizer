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

    private Double pontuacaoAbsoluta;

    private Double artilhariaMedia;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getArtilhariaMedia() {
        return artilhariaMedia;
    }

    public void setArtilhariaMedia(Double artilhariaMedia) {
        this.artilhariaMedia = artilhariaMedia;
    }

    /**
     * nro de pontos/nro de peladas
     */
    public Double getPontuacaoAbsoluta() {
        return pontuacaoAbsoluta;
    }

    public void setPontuacaoAbsoluta(Double pontuacaoAbsoluta) {
        this.pontuacaoAbsoluta = pontuacaoAbsoluta;
    }

    public Double getScore() {
        return pontuacaoAbsoluta * artilhariaMedia;
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
