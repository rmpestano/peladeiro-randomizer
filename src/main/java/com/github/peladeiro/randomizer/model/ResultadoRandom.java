package com.github.peladeiro.randomizer.model;

import java.util.ArrayList;

/**
 * Created by pestano on 14/11/15.
 */
public class ResultadoRandom {

    private Time time1 = new Time(new ArrayList<>());

    private Time time2 = new Time(new ArrayList<>());

    public ResultadoRandom(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void adicionaPeladeiroTime1(Peladeiro peladeiro) {
        time1.addPeladeiro(peladeiro);
    }

    public void adicionaPeladeiroTime2(Peladeiro peladeiro) {
        time2.addPeladeiro(peladeiro);
    }

    public Double getPontuacaoTimes() {
        return time1.getPontuacao() + time2.getPontuacao();
    }

    public Double getDiferencaPontuacaoTimes() {
        return Math.abs(time1.getPontuacao() - time2.getPontuacao());
    }


    @Override
    public String toString() {
        return String.format("Pontuação time1: %f\nPontuação time2: %f", time1.getPontuacao(), time2.getPontuacao());
    }
}
