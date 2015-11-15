package com.github.peladeiro.randomizer.service;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 14/11/15.
 */
@RunWith(CdiTestRunner.class)
public class StatisticsImporterTest {

    private final File pontuacaoAbsolutaFile = new File(Paths.get("").toAbsolutePath() + "/target/test-classes/pontuacao-absoluta.txt");

    private final File artilhariaFile = new File(Paths.get("").toAbsolutePath() + "/target/test-classes/artilharia.txt");


    @Inject
    private StatisticsImporter importer;

    @Inject
    private PeladeiroManager peladeiroManager;

    @Before
    public void setup() {
        assertThat(pontuacaoAbsolutaFile).exists();
    }


    @Test
    public void deveImportarPontuacaoAbsoluta() {
        importer.importaPontuacaoAbsoluta(TestConstants.PONTUACAO);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent()).isTrue();
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getPontuacaoAbsoluta()).isEqualTo(1.22D);
    }

    @Test
    public void deveImportarArtilharia() {
        importer.importaArtilharia(TestConstants.ARTILHARIA);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent()).isTrue();
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getArtilhariaMedia()).isEqualTo(1.81D);
    }

    @Test
    public void deveImportarArtilhariaEPontuacaoAbsoluta() {
        importer.importaArtilharia(TestConstants.ARTILHARIA);
        importer.importaPontuacaoAbsoluta(TestConstants.PONTUACAO);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent());
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getPontuacaoAbsoluta()).isEqualTo(1.22D);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent()).isTrue();
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getArtilhariaMedia()).isEqualTo(1.81D);
    }
}
