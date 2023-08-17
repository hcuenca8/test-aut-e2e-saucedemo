package com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.constants.enums;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public enum EstadoElemento {

    VISIBLE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return elemento.isVisibleFor(actor);
            //return elemento.resolveFor(actor).isVisible();
        }
    },
    NO_VISIBLE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return !elemento.isVisibleFor(actor);
            //return !elemento.resolveFor(actor).isVisible();
        }
    },
    HABILITADO {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return elemento.resolveFor(actor).isEnabled();
        }
    },
    DESHABILITADO {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return !elemento.resolveFor(actor).isEnabled();
        }
    },
    PRESENTE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return elemento.resolveFor(actor).isPresent();
        }
    },
    NO_PRESENTE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return !elemento.resolveFor(actor).isPresent();
        }
    },
    CLICKABLE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return elemento.resolveFor(actor).isClickable();
        }
    },
    NO_CLICKABLE {
        @Override
        public boolean esCuando(Actor actor, Target elemento) {
            return !elemento.resolveFor(actor).isClickable();
        }
    },

    ;

    public abstract boolean esCuando(Actor actor, Target elemento);
}
