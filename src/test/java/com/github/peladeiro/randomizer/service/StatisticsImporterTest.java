package com.github.peladeiro.randomizer.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.peladeiro.randomizer.util.TestConstants;

/**
 * Created by pestano on 14/11/15.
 */
@RunWith(CdiTestRunner.class)
public class StatisticsImporterTest {


    @Inject
    private StatisticsImporter importer;

    @Inject
    private PeladeiroManager peladeiroManager;
 

    @Test
    public void deveImportarPontuacaoAbsoluta() {
        importer.importaPontuacaoAbsoluta(TestConstants.PONTUACAO);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent()).isTrue();
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getPontuacaoMedia()).isEqualTo(1.22D);
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
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getPontuacaoMedia()).isEqualTo(1.22D);
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").isPresent()).isTrue();
        assertThat(peladeiroManager.getPeladeiro("Rafael Pestano").get().getArtilhariaMedia()).isEqualTo(1.81D);
    }
}
