package com.github.peladeiro.randomizer.service;

import com.github.peladeiro.randomizer.infra.exception.CustomException;
import com.github.peladeiro.randomizer.model.Peladeiro;
import com.github.peladeiro.randomizer.model.ResultadoRandom;
import com.github.peladeiro.randomizer.model.Time;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by pestano on 14/11/15.
 */
@RequestScoped
public class RandomService {

    public ResultadoRandom randomSort(List<Peladeiro> peladeiros) {
        if (peladeiros.size() % 2 != 0) {
            throw new CustomException("O número de participantes da pelada deve ser par");
        }

        Collections.shuffle(peladeiros, new Random(System.currentTimeMillis()));

        Time time1 = new Time(new ArrayList<>());
        Time time2 = new Time(new ArrayList<>());

        //time1 indices pares do array
        time1.getJogadores().addAll(peladeiros.stream()
                        .filter(p -> peladeiros.indexOf(p) % 2 == 0)
                        .collect(Collectors.toList())
        );

        //time2 indices impares do array
        time2.getJogadores().addAll(peladeiros.stream()
                        .filter(p -> peladeiros.indexOf(p) % 2 != 0)
                        .collect(Collectors.toList())
        );


        return new ResultadoRandom(time1, time2);
    }
}
