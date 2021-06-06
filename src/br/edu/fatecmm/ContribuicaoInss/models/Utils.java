package br.edu.fatecmm.ContribuicaoInss.models;

public class Utils {
    public static String formatarValorDoubleParaString(Double valor){
        return "R$ " +  String.format("%.02f", valor);
    }

    public static Double formatarValorStringParaDouble(String valor){
        return Double.parseDouble(valor.substring(3).replace(",", "."));
    }
}
