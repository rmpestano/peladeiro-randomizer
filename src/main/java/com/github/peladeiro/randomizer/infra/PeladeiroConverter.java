package com.github.peladeiro.randomizer.infra;

import com.github.peladeiro.randomizer.service.PeladeiroManager;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Created by pestano on 14/11/15.
 */
@FacesConverter("peladeiroConverter")
public class PeladeiroConverter implements Converter{

    @Inject
    PeladeiroManager manager;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return manager.getPeladeiro(value).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
