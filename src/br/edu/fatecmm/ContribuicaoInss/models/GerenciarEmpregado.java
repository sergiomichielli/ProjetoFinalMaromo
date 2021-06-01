package br.edu.fatecmm.ContribuicaoInss.models;


import java.util.ArrayList;

public class GerenciarEmpregado {
    private ArrayList <Empregado> listaEmpregados;

    public void adicionarEmpregado(Empregado e) {
        listaEmpregados.add(e);
    }

    public void removerEmpregado(Empregado e) {
        boolean existeEmpregado = verificarExistencia(e);

        if(existeEmpregado == true) {
            listaEmpregados.remove(e);
        }
    }

    private boolean verificarExistencia(Empregado e) {
       return listaEmpregados.contains(e);
    }

    public ArrayList <Empregado> listarEmpregados() {
        return listaEmpregados;
    }
}
