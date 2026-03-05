package org.pilotosf1iterator.Repository;

import org.pilotosf1iterator.Iterator.*;
import org.pilotosf1iterator.Model.Piloto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class PilotoRepository {
    private final String caminhoArquivo;

    public PilotoRepository(String caminho) {
        this.caminhoArquivo = caminho;
    }

    private List<Piloto> interpretaArquivo() throws Exception {
        List<Piloto> listaPilotos = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    listaPilotos.add(new Piloto(linha));
                }
            }
        }
        return listaPilotos;
    }

    public Iterator<Piloto> getPilha() throws Exception {
        Stack<Piloto> pilha = new Stack<>();
        pilha.addAll(interpretaArquivo());
        return new IteratorPilha(pilha);
    }

    public Iterator<Piloto> getFila() throws Exception {
        LinkedList<Piloto> fila = new LinkedList<>(interpretaArquivo());
        return new IteratorFila(fila);
    }

    public Iterator<Piloto> getArvore() throws Exception {
        TreeSet<Piloto> arvore = new TreeSet<>(interpretaArquivo());
        return new IteratorArvore(arvore);
    }

    public Iterator<Piloto> getMatriz() throws Exception {
        List<Piloto> listaPilotos = interpretaArquivo();
        int total = listaPilotos.size();

        int colunas = 10;
        int linhas = (int) Math.ceil((double) total / colunas);

        Piloto[][] matriz = new Piloto[linhas][colunas];

        int l = 0, c = 0;
        for (Piloto p : listaPilotos) {
            matriz[l][c] = p;
            c++;
            if (c == colunas) {
                c = 0;
                l++;
            }
        }
        return new IteratorMatriz(matriz);
    }

    public Iterator<Piloto> getGrafo() throws Exception {
        List<Piloto> listaPilotos = interpretaArquivo();
        HashMap<Piloto, LinkedList<Piloto>> grafo = new HashMap<>();
        for (Piloto p : listaPilotos) {
            grafo.put(p, new LinkedList<>());
        }
        return new IteratorGrafo(grafo);
    }
}
