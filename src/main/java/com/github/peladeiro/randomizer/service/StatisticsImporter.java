/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.peladeiro.randomizer.service;

import com.github.peladeiro.randomizer.infra.exception.CustomException;
import com.github.peladeiro.randomizer.infra.util.Util;
import com.github.peladeiro.randomizer.model.Peladeiro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author rmpestano
 */
@RequestScoped
public class StatisticsImporter implements Serializable {


    @Inject
    PeladeiroManager peladeiroManager;

    Logger log = Logger.getLogger(getClass().getName());


    public void importaPontuacaoAbsoluta(String pontuacao) {
        try {
            String[] lines = pontuacao.split(System.getProperty("line.separator"));
            for (String line : lines) {
                    String[] split = line.split("\t");

                    Peladeiro peladeiro = new Peladeiro();
                    String nome = split[0].substring(split[0].indexOf("-") + 1).trim();
                    if (peladeiroManager.peladeiroExiste(nome)) {
                        //peladeiro ja exite entao atualiza suas estaticas senao cria novo
                        peladeiro = peladeiroManager.getPeladeiro(nome).get();
                    } else {
                        peladeiroManager.inclui(peladeiro);
                    }
                    peladeiro.setNome(nome);

                    NumberFormat nf = Util.getNumberFormat();
                    //nro vitorias/ nro jogos
                    String pontuacaoMedia = nf.format(nf.parse(split[1].trim()).doubleValue() / nf.parse(split[2].trim()).doubleValue());

                    peladeiro.setPontuacaoMedia(Double.valueOf(pontuacaoMedia));

            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Não foi possível importar pontuação", e);
            throw new CustomException("Não foi possível importar pontuação");

        }
    }

    public void importaArtilharia(String artilharia) {

        try {
            String[] lines = artilharia.split(System.getProperty("line.separator"));
            for (String line : lines) {
                    String[] split = line.split("\t");

                    Peladeiro peladeiro = new Peladeiro();
                    String nome = split[0].substring(split[0].indexOf("-") + 1).trim();
                    if (peladeiroManager.peladeiroExiste(nome)) {
                        //peladeiro ja exite entao atualiza suas estaticas senao cria novo
                        peladeiro = peladeiroManager.getPeladeiro(nome).get();
                    } else {
                        peladeiroManager.inclui(peladeiro);
                    }
                    peladeiro.setNome(nome);

                    peladeiro.setArtilhariaMedia(Util.getNumberFormat().parse(split[1].trim()).doubleValue());
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Não foi possível importar artilharia", e);
            throw new CustomException("Não foi possível importar artilharia");
        }
    }


}
