package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.HashMap;
import java.util.Iterator;

public class IteratorHash implements Iterator<Piloto> {
    private final Iterator<Piloto> iterator;

    public IteratorHash(HashMap<Piloto, ?> grafo) {
        this.iterator = grafo.keySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Piloto next() {
        return iterator.next();
    }
}
