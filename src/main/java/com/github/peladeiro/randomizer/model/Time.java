package com.github.peladeiro.randomizer.model;

import com.github.peladeiro.randomizer.infra.util.Util;

import java.util.List;

/**
 * Created by pestano on 14/11/15.
 */
public class Time {

    private List<Peladeiro> jogadores;


    public Time(List<Peladeiro> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Peladeiro> getJogadores() {
        return jogadores;
    }

    public Double getPontuacao() {
        return Double.valueOf(Util.getNumberFormat().format(jogadores.stream()
                .mapToDouble(j -> j.getScore())
                .sum()));

    }


    public void addPeladeiro(Peladeiro peladeiro) {
        getJogadores().add(peladeiro);
    }


}
