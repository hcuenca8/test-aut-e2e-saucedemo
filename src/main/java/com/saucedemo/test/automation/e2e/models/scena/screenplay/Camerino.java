package com.saucedemo.test.automation.e2e.models.scena.screenplay;

import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * Copy de clase Cast
 */
public class Camerino extends Cast {

    private final List<Ability> standardAbilities;
    private final List<Consumer<Actor>> abilityProviders;
    Map<String, Actor> actors = new HashMap();

    private Camerino() {
        this(new Ability[]{});
    }

    private Camerino(Ability[] abilities) {
        this.standardAbilities = asList(abilities);
        this.abilityProviders = new ArrayList<>();
    }

    private Camerino(Consumer<Actor>... providers) {
        this.standardAbilities = new ArrayList<>();
        this.abilityProviders = asList(providers);
    }

    public Actor actorNamed(String actorName, Ability... abilities) {

        if (! actors.containsKey(actorName)) {
            Actor newActor = Actor.named(actorName);

            for(Ability doSomething : abilities) {
                newActor.can(doSomething);
            }

            assignGeneralAbilitiesTo(newActor);

            actors.put(actorName, newActor);
        }
        return actors.get(actorName);
    }

    public List<Actor> getActors() {
        return NewList.copyOf(actors.values());
    }

    public void dismissAll() {
        for (Actor actor : actors.values()) {
            actor.wrapUp();
        }
        actors.clear();
    }

    protected void assignGeneralAbilitiesTo(Actor newActor) {
        standardAbilities.forEach(newActor::whoCan);
        abilityProviders.forEach(
            ability -> ability.accept(newActor)
        );
    }

    /**
     * Comportamientos adicionales/personalizados
     */

    private static Camerino camerino;

    public static Camerino delElenco()
    {
        if  (   Camerino.camerino==null )
        {
            Camerino.camerino = new Camerino();
            OnStage.setTheStage(camerino);
        }
        return Camerino.camerino;
    }

    public Map<String, Actor> getHmActors() {
        return actors;
    }

    public Camerino preparaAlProtagonista(String enSuPapel, Actor protagonico)
    {
        Map<String, Actor> hmActors = Camerino.delElenco().getHmActors();

        if  (   !hmActors.containsKey(enSuPapel)  )
        {
            hmActors.put(enSuPapel,protagonico);
        }

        return Camerino.delElenco();
    }
}
