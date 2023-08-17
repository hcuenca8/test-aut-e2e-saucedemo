package com.saucedemo.test.automation.e2e.models.scena.screenplay;

import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;


public class Protagonista extends Actor{

    private static Protagonista protagonista;
    private boolean tieneSesionActiva;
    private Libreto libreto;
    private Map<String, ITablaGherkin<?>> tblsGherkin;
    private Map<String, String> tblGherkin;
    private static final String ANONIMO = "anonimo";

    private Protagonista(String nombre)
    {
        super(nombre);
    }

    public static boolean haActuadoPreviamente(String como){
        return Protagonista.estaEnEscena(como);
    }

    private static boolean estaEnEscena(String como)
    {
        boolean estaEnEscena = OnStage.stage().anActorIsOnStage();

        como = como == null || como.trim().isEmpty()
            ? ANONIMO
            : como;
        Protagonista.principal().assignName(como);

        if  (   estaEnEscena  )
        {
            if  (   !como.equalsIgnoreCase(OnStage.theActorInTheSpotlight().getName())  )
            {
                estaEnEscena = false;
            }
        }

        return estaEnEscena;
    }

    public static Protagonista principal()
    {
        if(Protagonista.protagonista==null){
            Protagonista.protagonista = new Protagonista(ANONIMO);
        }
        return Protagonista.protagonista;
    }

    public static Protagonista entraEnEscena(String como)
    {
        Camerino.delElenco().preparaAlProtagonista(como,Protagonista.principal());
        OnStage.theActorCalled(como);
        return Protagonista.principal();
    }

    public static Protagonista enEscena()
    {
        Protagonista enEscena;
        if  (   Protagonista.estaEnEscena(Protagonista.principal().getName())   )
        {
            enEscena = Protagonista.principal();
        }else{
            enEscena = null;
        }

        return enEscena;
    }

    public String conElPapelDe(){
        return super.getName();
    }


    public static void sePreparaParaSiguienteEscena(){
        Protagonista.protagonista = null;
    }

    public boolean isTieneSesionActiva() {
        return tieneSesionActiva;
    }

    public void setTieneSesionActiva(boolean tieneSesionActiva) {
        this.tieneSesionActiva = tieneSesionActiva;
    }

    public Libreto getLibreto()
    {
        if  (   this.libreto == null   )
        {
            this.libreto = new Libreto();
        }
        return libreto;
    }

    private Map<String, ITablaGherkin<?>> getTblsGherkin()
    {
        if  (   this.tblsGherkin == null  )
        {
            tblsGherkin = new HashMap<>();
            TablaGherkinUtil.cargarTablasGherkin(this.tblsGherkin);
        }

        return this.tblsGherkin;
    }

    public Map<String, String> getTblGherkin()
    {
        if  (   this.tblGherkin == null  )
        {
            tblGherkin = new HashMap<>();
        }

        return this.tblGherkin;
    }

    public void ensayarLibreto(Map<String, String> tblGherkin)
    {
        TablaGherkinUtil.deLaTabla(tblGherkin).cruzarCon(this.getTblsGherkin());

    }
}
