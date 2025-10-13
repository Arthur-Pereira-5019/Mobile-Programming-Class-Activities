package com.example.app;

import java.util.ArrayList;

public class PlanetaController {
    PlanetaDAO planetaDAO;

    public PlanetaController() {
        planetaDAO = new PlanetaDAO();
    }
    public void addPlaneta(Planeta planeta) {

    }

    public ArrayList<String> getNomePlanetas(){
        ArrayList<String> nomes = new ArrayList<>();
        for(Planeta p: planetaDAO.getPlanetas()) {
            nomes.add(p.nome);
        }
        return nomes;
    }

    public ArrayList<Planeta> getPlaneta() {
        return planetaDAO.getPlanetas();
    }
}
