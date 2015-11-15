package com.github.peladeiro.randomizer.service;

import com.github.peladeiro.randomizer.model.Peladeiro;
import com.github.peladeiro.randomizer.model.ResultadoRandom;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 14/11/15.
 */
@RunWith(CdiTestRunner.class)
public class RandomServiceTest {

    private final File pontuacaoAbsolutaFile = new File(Paths.get("").toAbsolutePath() + "/target/test-classes/pontuacao-absoluta.txt");

    private final File artilhariaFile = new File(Paths.get("").toAbsolutePath() + "/target/test-classes/artilharia.txt");


    @Inject
    private StatisticsImporter importer;

    @Inject
    private PeladeiroManager peladeiroManager;

    @Inject
    private RandomService randomService;


    @Before
    public void setup() {
        assertThat(pontuacaoAbsolutaFile).exists();
    }


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

        System.out.println(resultadoRandom);
    }
}
