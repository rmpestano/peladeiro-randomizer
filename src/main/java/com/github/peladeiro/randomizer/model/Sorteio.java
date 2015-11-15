package com.github.peladeiro.randomizer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by pestano on 14/11/15.
 *
 * apenas contabiliza o numero de sorteios
 */
@Entity
@NamedQuery(name = "Sorteio.count", query = "select count(s.id) from Sorteio s")
public class Sorteio {

    @Id
    @GeneratedValue
    private Long id;

}
