package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.Iterator;
import java.util.PriorityQueue;

public class IteratorPrioridade implements Iterator<Piloto> {
    private final PriorityQueue<Piloto> copiaFila;

    public IteratorPrioridade(PriorityQueue<Piloto> filaOriginal) {
        this.copiaFila = new PriorityQueue<>(filaOriginal.comparator());
        this.copiaFila.addAll(filaOriginal);
    }

    @Override
    public boolean hasNext() {
        return !copiaFila.isEmpty();
    }

    @Override
    public Piloto next() {
        return copiaFila.poll();
    }

}
