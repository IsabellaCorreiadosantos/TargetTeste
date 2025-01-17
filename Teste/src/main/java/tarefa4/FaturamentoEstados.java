package tarefa4;

import java.util.HashMap;
import java.util.Map;

public class FaturamentoEstados {

	public static void main(String[] args) {
       
        Map<String, Double> faturamentoEstados = new HashMap<>();
        faturamentoEstados.put("SP", 67836.43);
        faturamentoEstados.put("RJ", 36678.66);
        faturamentoEstados.put("MG", 29229.88);
        faturamentoEstados.put("ES", 27165.48);
        faturamentoEstados.put("Outros", 19849.53);

       
        double faturamentoTotal = faturamentoEstados.values().stream().mapToDouble(Double::doubleValue).sum();

        
        System.out.println("Percentual de representação por estado:");
        for (Map.Entry<String, Double> entry : faturamentoEstados.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado, percentual);
        }
    }
}