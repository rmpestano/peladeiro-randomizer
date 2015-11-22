package com.github.peladeiro.randomizer.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.peladeiro.randomizer.model.Peladeiro;
import com.github.peladeiro.randomizer.model.ResultadoRandom;
import com.github.peladeiro.randomizer.util.TestConstants;

/**
 * Created by pestano on 14/11/15.
 */
@RunWith(CdiTestRunner.class)
public class RandomServiceTest {


    @Inject
    private StatisticsImporter importer;

    @Inject
    private PeladeiroManager peladeiroManager;

    @Inject
    private RandomService randomService;



    @Test
    public void deveEmbaralharTimes() {
        importer.importaArtilharia(TestConstants.ARTILHARIA);
        importer.importaPontuacaoAbsoluta(TestConstants.PONTUACAO);

        List<Peladeiro> peladeiros = peladeiroManager.getPeladeiros();
        ResultadoRandom resultadoRandom = randomService.randomSort(peladeiros);

        assertThat(resultadoRandom.getTime1()).isNotNull();
        assertThat(resultadoRandom.getTime1().getJogadores()).isNotNull();
        assertThat(resultadoRandom.getTime1().getJogadores()).hasSize(18);
        assertThat(resultadoRandom.getTime2()).isNotNull();

        assertThat(resultadoRandom.getTime1().getJogadores().size()).isEqualTo(resultadoRandom.getTime2().getJogadores().size());

    }
}
