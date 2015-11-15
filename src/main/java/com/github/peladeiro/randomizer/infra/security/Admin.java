package com.github.peladeiro.randomizer.infra.security;

/**
 * Created by rmpestano on 12/20/14.
 */

import org.apache.deltaspike.security.api.authorization.SecurityBindingType;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@SecurityBindingType
public @interface Admin {

}
