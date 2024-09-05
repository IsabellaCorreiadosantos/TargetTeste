package com.tarefa3.teste;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class FaturamentoService {

    public void processarFaturamento() throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/dados.json");
        List<Faturamento> faturamentos = mapper.readValue(is, new TypeReference<List<Faturamento>>() {});

        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        
        for (Faturamento f : faturamentos) {
            double valor = f.getValor();

           
            if (valor > 0) {
                somaFaturamento += valor;
                diasComFaturamento++;

                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
            }
        }

        
        double mediaFaturamento = somaFaturamento / diasComFaturamento;

        
        int diasAcimaDaMedia = 0;
        for (Faturamento f : faturamentos) {
            if (f.getValor() > mediaFaturamento) {
                diasAcimaDaMedia++;
            }
        }

        
        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
