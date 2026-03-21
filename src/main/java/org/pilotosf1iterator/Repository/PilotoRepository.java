package org.pilotosf1iterator.Repository;

import org.pilotosf1iterator.Iterator.*;
import org.pilotosf1iterator.Model.Piloto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class PilotoRepository {
    private final String nomeArquivo;

    public PilotoRepository(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    private List<Piloto> cachePilotos;

    private List<Piloto> interpretaArquivo() throws Exception {
        if (cachePilotos != null) return cachePilotos;

        cachePilotos = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    cachePilotos.add(new Piloto(linha));
                }
            }
        }
        return cachePilotos;
    }

    public Iterator<Piloto> getPilha() throws Exception {
        Stack<Piloto> pilha = new Stack<>();
        pilha.addAll(interpretaArquivo());
        return new IteratorPilha(pilha);
    }

    public Iterator<Piloto> getFila() throws Exception {
        return new IteratorFila(new LinkedList<>(interpretaArquivo()));
    }

    public Iterator<Piloto> getArvore() throws Exception {
        return new IteratorArvore(new TreeSet<>(interpretaArquivo()));
    }

    public Iterator<Piloto> getPrioridade() throws Exception {
        Comparator<Piloto> porPontos = (p1, p2) -> Integer.compare(p2.getPontos(), p1.getPontos());
        PriorityQueue<Piloto> filaPrioridade = new PriorityQueue<>(porPontos);
        filaPrioridade.addAll(interpretaArquivo());
        return new IteratorPrioridade(filaPrioridade);
    }

    public Iterator<Piloto> getSet() throws Exception {
        Set<Piloto> hashSet = new HashSet<>(interpretaArquivo());
        return new IteratorSet(hashSet);
    }

}
