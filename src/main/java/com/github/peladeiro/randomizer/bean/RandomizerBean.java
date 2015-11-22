package com.github.peladeiro.randomizer.bean;

import com.github.peladeiro.randomizer.infra.exception.CustomException;
import com.github.peladeiro.randomizer.model.Peladeiro;
import com.github.peladeiro.randomizer.model.ResultadoRandom;
import com.github.peladeiro.randomizer.model.Sorteio;
import com.github.peladeiro.randomizer.service.PeladeiroManager;
import com.github.peladeiro.randomizer.service.RandomService;
import com.github.peladeiro.randomizer.service.StatisticsImporter;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pestano on 14/11/15.
 */
@Named
@ViewAccessScoped
public class RandomizerBean implements Serializable {

    @Inject
    private PeladeiroManager peladeiroManager;

    @Inject
    private StatisticsImporter statisticsImporter;

    @Inject
    private RandomService randomService;

    @PersistenceContext
    private EntityManager em;

    private String textArtilharia;

    private String textPontuacaoAbsoluta;

    private Integer numeroRepeticoes;

    private ResultadoRandom timesRandomizados;

    private DualListModel<Peladeiro> peladeirosPickList;

    private List<Peladeiro> disponiveis; //peladeiros encontrados na importacao

    private List<Peladeiro> participantes; //participantes da pelada

    @PostConstruct
    public void init() {
        peladeiroManager.getPeladeiros().clear();
        numeroRepeticoes = 10;
    }


    @Transactional
    public void randomize() {
        timesRandomizados = null;
        if (getPeladeirosPickList().getTarget() == null || getPeladeirosPickList().getTarget().isEmpty()) {
            throw new CustomException("Selecione os participantes da pelada");
        }
        for (int i = 0; i < numeroRepeticoes; i++) {
            ResultadoRandom resultadoRandom = randomService.randomSort(getPeladeirosPickList().getTarget());
            if (timesRandomizados == null || timesRandomizados.getDiferencaPontuacaoTimes() > resultadoRandom.getDiferencaPontuacaoTimes()) {
                timesRandomizados = resultadoRandom;
            }
        }

        em.persist(new Sorteio());

    }

    public Long numSorteios() {
        return (Long) em.createNamedQuery("Sorteio.count").getSingleResult();
    }

    public void importarEstatisticas() {
        statisticsImporter.importaArtilharia(textArtilharia);
        statisticsImporter.importaPontuacaoAbsoluta(textPontuacaoAbsoluta);

        disponiveis = peladeiroManager.getPeladeiros();
        Collections.sort(disponiveis, (p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        participantes = new ArrayList<>();
        peladeirosPickList = new DualListModel<>(disponiveis, participantes);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Importação realizada com sucesso!"));
    }

    public String getTextArtilharia() {
        return textArtilharia;
    }

    public void setTextArtilharia(String textArtilharia) {
        this.textArtilharia = textArtilharia;
    }

    public String getTextPontuacaoAbsoluta() {
        return textPontuacaoAbsoluta;
    }

    public void setTextPontuacaoAbsoluta(String textPontuacaoAbsoluta) {
        this.textPontuacaoAbsoluta = textPontuacaoAbsoluta;
    }

    public Integer getNumeroRepeticoes() {
        return numeroRepeticoes;
    }

    public void setNumeroRepeticoes(Integer numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }

    public ResultadoRandom getTimesRandomizados() {
        return timesRandomizados;
    }

    public void setTimesRandomizados(ResultadoRandom timesRandomizados) {
        this.timesRandomizados = timesRandomizados;
    }

    public DualListModel<Peladeiro> getPeladeirosPickList() {
        return peladeirosPickList;
    }

    public void setPeladeirosPickList(DualListModel<Peladeiro> peladeirosPickList) {
        this.peladeirosPickList = peladeirosPickList;
    }

    public void reImportar() {
        peladeirosPickList = null;
        timesRandomizados = null;
    }
}
