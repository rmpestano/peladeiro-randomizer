package com.github.peladeiro.randomizer.service;

import com.github.peladeiro.randomizer.model.Peladeiro;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by pestano on 14/11/15.
 */
@SessionScoped
public class PeladeiroManager implements Serializable {

    private List<Peladeiro> peladeiros = new ArrayList<>();

    public void inclui(Peladeiro peladeiro) {

        peladeiros.add(peladeiro);
    }

    public Optional<Peladeiro> getPeladeiro(String nome) {
        return peladeiros.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public List<Peladeiro> getPeladeiros() {
        return peladeiros;
    }

    public boolean peladeiroExiste(String nome) {
        return getPeladeiro(nome).isPresent();
    }
}
