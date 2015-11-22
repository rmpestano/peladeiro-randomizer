package com.github.peladeiro.randomizer.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.peladeiro.randomizer.model.Peladeiro;

@RunWith(JUnit4.class)
public class PeladeiroTest {
	
	
	
	@Test
	public void deveCalcularScore(){
		Peladeiro peladeiro = new Peladeiro();
		
		peladeiro.setArtilhariaMedia(1D);
		peladeiro.setPontuacaoMedia(1D);
		
		assertThat(peladeiro.getScore()).isEqualTo(1.15);
	}

}
