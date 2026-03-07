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

    private LinkedList<Piloto> interpretaArquivo() throws Exception {
        LinkedList<Piloto> listaPilotos = new LinkedList<>();
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
        LinkedList<Piloto> fila = interpretaArquivo();
        return new IteratorFila(fila);
    }

    public Iterator<Piloto> getArvore() throws Exception {
        TreeSet<Piloto> arvore = new TreeSet<>(interpretaArquivo());
        return new IteratorArvore(arvore);
    }

    public Iterator<Piloto> getPrioridade() throws Exception {
        Comparator<Piloto> porPontos = (p1, p2) -> Integer.compare(p2.getPontos(), p1.getPontos());
        PriorityQueue<Piloto> filaPrioridade = new PriorityQueue<>(porPontos);
        filaPrioridade.addAll(interpretaArquivo());
        return new IteratorPrioridade(filaPrioridade);
    }

    public Iterator<Piloto> getHash() throws Exception {
        HashMap<Piloto, LinkedList<Piloto>> hash = new HashMap<>();
        for (Piloto p : interpretaArquivo()) {
            hash.put(p, new LinkedList<>());
        }
        return new IteratorHash(hash);
    }

}
