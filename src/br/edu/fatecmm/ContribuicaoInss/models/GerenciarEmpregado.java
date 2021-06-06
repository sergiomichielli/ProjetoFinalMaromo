package br.edu.fatecmm.ContribuicaoInss.models;


import java.util.ArrayList;

public class GerenciarEmpregado {
    private ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();
    private double valor;

    public void adicionarEmpregado(Empregado e) {
        listaEmpregados.add(e);
    }

    public void removerEmpregado(Empregado e) {
        boolean existeEmpregado = verificarExistencia(e);

        if (existeEmpregado == true) {
            listaEmpregados.remove(e);
        }
    }

    private boolean verificarExistencia(Empregado e) {
        return listaEmpregados.contains(e);
    }

    public ArrayList<Empregado> listarEmpregados() {
        return listaEmpregados;
    }

    public double calcularInss(Empregado e) {
        ParamentroInss parametros = new ParamentroInss();
        double resultado = 0.0;

        if (e.getSalarioBruto() > parametros.LIMITEFAIXA3 || e.getSalarioBruto() >= parametros.LIMITEFAIXA4) {
            double limite = e.getSalarioBruto();
            if (e.getSalarioBruto() >= parametros.LIMITEFAIXA4) {
                limite = parametros.LIMITEFAIXA4;
            }
            resultado = resultado + ((limite - parametros.LIMITEFAIXA3) * parametros.FAIXA4);
        }

        if (e.getSalarioBruto() > parametros.LIMITEFAIXA2 || e.getSalarioBruto() >= parametros.LIMITEFAIXA3) {
            double limite = parametros.LIMITEFAIXA3;
            if (e.getSalarioBruto() >= parametros.LIMITEFAIXA2 && e.getSalarioBruto() <= parametros.LIMITEFAIXA3) {
                limite = e.getSalarioBruto();
            }
            resultado = resultado + ((limite - parametros.LIMITEFAIXA2) * parametros.FAIXA3);
        }
        if (e.getSalarioBruto() > parametros.LIMITEFAIXA1 || e.getSalarioBruto() >= parametros.LIMITEFAIXA2) {
            double limite = parametros.LIMITEFAIXA2;
            if (e.getSalarioBruto() >= parametros.LIMITEFAIXA1 && e.getSalarioBruto() <= parametros.LIMITEFAIXA2) {
                limite = e.getSalarioBruto();
            }
            resultado = resultado + ((limite - parametros.LIMITEFAIXA1) * parametros.FAIXA2);
        }

        double limite = parametros.LIMITEFAIXA1;
        if (e.getSalarioBruto() <= parametros.LIMITEFAIXA1) {
            limite = e.getSalarioBruto();
        }
        resultado = resultado + limite * parametros.FAIXA1;

        return resultado;
    }
}
