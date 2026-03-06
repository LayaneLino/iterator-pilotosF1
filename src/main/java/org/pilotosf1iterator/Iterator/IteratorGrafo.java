package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorGrafo implements Iterator<Piloto> {
    private final LinkedList<Piloto> chaves;

    public IteratorGrafo(HashMap<Piloto, ?> grafo) {
        this.chaves = new LinkedList<>(grafo.keySet());
    }

    @Override
    public boolean hasNext() {
        return !chaves.isEmpty();
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return chaves.removeFirst();
    }
}
