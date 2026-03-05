package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class IteratorGrafo implements Iterator<Piloto> {
    private final List<Piloto> chaves;
    private int pos;

    public IteratorGrafo(HashMap<Piloto, ?> grafo) {
        this.chaves = new ArrayList<>(grafo.keySet());
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < chaves.size();
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return chaves.get(pos++);
    }
}
