package com.github.peladeiro.randomizer.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.peladeiro.randomizer.model.Peladeiro;
import com.github.peladeiro.randomizer.model.Time;

@RunWith(JUnit4.class)
public class TimeTest {

	@Test
	public void deveCalcularPontuacaoDo(){
		
		List<Peladeiro> peladeiros = new ArrayList<Peladeiro>();
		peladeiros.add(new Peladeiro().setNome("Peladeiro").
				setPontuacaoMedia(1.0).
				setArtilhariaMedia(1.0) //1.15
				);
		peladeiros.add(new Peladeiro().setNome("Peladeiro 2").
				setPontuacaoMedia(1.0).
				setArtilhariaMedia(2.0)
				);//2.30
				
		Time time = new Time(peladeiros);
		
		assertThat(time.getPontuacao()).isEqualTo(3.45);
		
	}
}
